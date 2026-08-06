package io.mgfirefox.collection.list

import io.mgfirefox.collection.KCCollection
import io.mgfirefox.collection.KCReadOnlyCollection
import io.mgfirefox.collection.KCWriteOnlyCollection
import io.mgfirefox.collection.iterable.KCWriteOnlyIterable
import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.collection.iterator.ElementIterator
import io.mgfirefox.collection.iterator.Iterator
import io.mgfirefox.exception.valid.index.IndexNotValidException
import io.mgfirefox.optional.Optional
import io.mgfirefox.stream.element.DefaultElementStream

class ArrayList<ElementT>(list: KCReadOnlyList<ElementT>) : List<ElementT> {

    private val list: KCArrayList<ElementT> = KCArrayList(list)

    override val count: Int
        get() = list.size

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other !is List<*>) {
            return false
        }

        if (list != other.unwrapList()) {
            return false
        }

        return true
    }

    override fun hashCode(): Int {
        return list.hashCode()
    }

    override fun get(index: Int): ElementT {
        if (!isIndexValid(index)) {
            throw IndexNotValidException(index, count)
        }

        return list[index]
    }

    override fun set(index: Int, element: ElementT) {
        if (!isIndexValid(index)) {
            throw IndexNotValidException(index, count)
        }

        list[index] = element
    }

    override fun contains(element: ElementT): Boolean {
        return element in list
    }

    private fun isIndexValid(index: Int): Boolean {
        return index in list.indices
    }

    override fun getIterator(): Iterator<ElementT> {
        return ElementIterator(list.iterator())
    }

    override fun getIndexOf(element: ElementT): Optional<Int> {
        val index: Int = list.indexOf(element)
        if (index == -1) {
            return Optional.ofEmpty()
        }

        return Optional.of(index)
    }

    override fun getLastIndexOf(element: ElementT): Optional<Int> {
        val index: Int = list.lastIndexOf(element)
        if (index == -1) {
            return Optional.ofEmpty()
        }

        return Optional.of(index)
    }

    override fun add(element: ElementT) {
        list.add(element)
    }

    override fun insertAt(index: Int, element: ElementT) {
        list.add(index, element)
    }

    override fun remove(element: ElementT): Boolean {
        return list.remove(element)
    }

    override fun removeAt(index: Int): ElementT {
        return list.removeAt(index)
    }

    override fun clear() {
        list.clear()
    }

    override fun unwrapWriteOnlyIterable(): KCWriteOnlyIterable<ElementT> {
        return unwrapCollection()
    }

    override fun unwrapReadOnlyCollection(): KCReadOnlyCollection<ElementT> {
        return unwrapCollection()
    }

    override fun unwrapWriteOnlyCollection(): KCWriteOnlyCollection<ElementT> {
        return unwrapCollection()
    }

    override fun unwrapCollection(): KCCollection<ElementT> {
        return unwrapList()
    }

    override fun unwrapReadOnlyList(): KCReadOnlyList<ElementT> {
        return unwrapList()
    }

    override fun unwrapWriteOnlyList(): KCWriteOnlyList<ElementT> {
        return unwrapList()
    }

    override fun unwrapList(): KCList<ElementT> {
        return unwrapArrayList()
    }

    fun unwrapArrayList(): KCArrayList<ElementT> {
        return KCArrayList(list)
    }

    override fun toString(): String {
        return list.toString()
    }

    companion object {

        @JvmStatic
        fun <ElementT> of(vararg elements: ElementT): ArrayList<ElementT> {
            val list: KCReadOnlyList<ElementT> = listOf(*elements)

            return ArrayList(list)
        }

        @JvmStatic
        fun <ElementT> from(iterable: ReadOnlyIterable<ElementT>): ArrayList<ElementT> {
            return DefaultElementStream(iterable).toArrayList()
        }
    }
}