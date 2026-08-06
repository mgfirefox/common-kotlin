package io.mgfirefox.collection.set

import io.mgfirefox.collection.KCCollection
import io.mgfirefox.collection.KCReadOnlyCollection
import io.mgfirefox.collection.KCWriteOnlyCollection
import io.mgfirefox.collection.iterable.KCWriteOnlyIterable
import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.collection.iterator.ElementIterator
import io.mgfirefox.collection.iterator.Iterator
import io.mgfirefox.stream.element.DefaultElementStream

class LinkedHashSet<ElementT>(set: KCReadOnlySet<ElementT>) : Set<ElementT> {

    private val set: KCLinkedHashSet<ElementT> = KCLinkedHashSet(set)

    override val count: Int
        get() = set.size

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other !is Set<*>) {
            return false
        }

        if (set != other.unwrapSet()) {
            return false
        }

        return true
    }

    override fun hashCode(): Int {
        return set.hashCode()
    }

    override fun contains(element: ElementT): Boolean {
        return element in set
    }

    override fun getIterator(): Iterator<ElementT> {
        return ElementIterator(set.iterator())
    }

    override fun add(element: ElementT) {
        insert(element)
    }

    override fun insert(element: ElementT): Boolean {
        val isElementInserted = set.add(element)

        return isElementInserted
    }

    override fun remove(element: ElementT): Boolean {
        return set.remove(element)
    }

    override fun clear() {
        set.clear()
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
        return unwrapSet()
    }

    override fun unwrapReadOnlySet(): KCReadOnlySet<ElementT> {
        return unwrapSet()
    }

    override fun unwrapWriteOnlySet(): KCWriteOnlySet<ElementT> {
        return unwrapSet()
    }

    override fun unwrapSet(): KCSet<ElementT> {
        return unwrapLinkedHashSet()
    }

    fun unwrapLinkedHashSet(): KCLinkedHashSet<ElementT> {
        return KCLinkedHashSet(set)
    }

    override fun toString(): String {
        return set.toString()
    }

    companion object {

        @JvmStatic
        fun <ElementT> of(vararg elements: ElementT): LinkedHashSet<ElementT> {
            val set: KCReadOnlySet<ElementT> = setOf(*elements)

            return LinkedHashSet(set)
        }

        @JvmStatic
        fun <ElementT> from(iterable: ReadOnlyIterable<ElementT>): LinkedHashSet<ElementT> {
            return DefaultElementStream(iterable).toLinkedHashSet()
        }
    }
}