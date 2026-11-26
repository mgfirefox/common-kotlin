package io.mgfirefox.collection.array

import io.mgfirefox.collection.KCReadOnlyCollection
import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.collection.iterator.ElementReadOnlyIterator
import io.mgfirefox.collection.iterator.ReadOnlyIterator
import io.mgfirefox.exception.valid.index.IndexNotValidException
import io.mgfirefox.optional.Optional
import io.mgfirefox.stream.KCStream
import io.mgfirefox.stream.element.DefaultElementStream

class TypedArray<ElementT>(array: KReadOnlyArray<ElementT>) : Array<ElementT> {

    private val array: KTypedArray<ElementT> = KTypedArray(array.size) { index -> array[index] }

    override val count: Int
        get() = array.size

    constructor(count: Int, initializer: ArrayInitializer<ElementT>) : this(
        KTypedArray(count, initializer))

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other !is Array<*>) {
            return false
        }

        if (!array.contentEquals(other.unwrapArray())) {
            return false
        }

        return true
    }

    override fun hashCode(): Int {
        return array.contentHashCode()
    }

    override fun get(index: Int): ElementT {
        if (!isIndexValid(index)) {
            throw IndexNotValidException(index, count)
        }

        return array[index]
    }

    override fun set(index: Int, element: ElementT) {
        if (!isIndexValid(index)) {
            throw IndexNotValidException(index, count)
        }

        array[index] = element
    }

    override fun contains(element: ElementT): Boolean {
        return element in array
    }

    private fun isIndexValid(index: Int): Boolean {
        return index in array.indices
    }

    override fun getIterator(): ReadOnlyIterator<ElementT> {
        return ElementReadOnlyIterator(array.iterator())
    }

    override fun getIndexOf(element: ElementT): Optional<Int> {
        val index: Int = array.indexOf(element)
        if (index == -1) {
            return Optional.ofEmpty()
        }

        return Optional.of(index)
    }

    override fun getLastIndexOf(element: ElementT): Optional<Int> {
        val index: Int = array.lastIndexOf(element)
        if (index == -1) {
            return Optional.ofEmpty()
        }

        return Optional.of(index)
    }

    override fun unwrapReadOnlyCollection(): KCReadOnlyCollection<ElementT> {
        val stream: KCStream<ElementT> = array.toList()

        val collection = DefaultElementStream(stream).toArrayList().unwrapReadOnlyCollection()

        return collection
    }

    override fun unwrapReadOnlyArray(): KReadOnlyArray<ElementT> {
        return unwrapArray()
    }

    override fun unwrapWriteOnlyArray(): KWriteOnlyArray<ElementT> {
        return unwrapArray()
    }

    override fun unwrapArray(): KArray<ElementT> {
        return unwrapTypedArray()
    }

    fun unwrapTypedArray(): KTypedArray<ElementT> {
        return array.copyOf()
    }

    override fun toString(): String {
        return array.contentToString()
    }

    companion object {

        @JvmStatic
        fun <ElementT> of(vararg elements: ElementT): TypedArray<ElementT> {
            return TypedArray(elements.size) { index -> elements[index] }
        }

        @JvmStatic
        fun <ElementT> ofNulls(count: Int): TypedArray<ElementT?> {
            return TypedArray(count) { null }
        }

        @JvmStatic
        fun <ElementT> from(iterable: ReadOnlyIterable<ElementT>): TypedArray<ElementT> {
            return DefaultElementStream(iterable).toTypedArray()
        }
    }
}