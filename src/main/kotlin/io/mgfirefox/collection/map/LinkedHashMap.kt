package io.mgfirefox.collection.map

import io.mgfirefox.collection.KCCollection
import io.mgfirefox.collection.KCReadOnlyCollection
import io.mgfirefox.collection.KCWriteOnlyCollection
import io.mgfirefox.collection.ReadOnlyCollection
import io.mgfirefox.collection.array.TypedArray
import io.mgfirefox.collection.iterable.KCWriteOnlyIterable
import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.collection.iterator.Iterator
import io.mgfirefox.collection.iterator.KCIterator
import io.mgfirefox.collection.iterator.MapPairIterator
import io.mgfirefox.collection.set.*
import io.mgfirefox.data.pair.Pair
import io.mgfirefox.exception.valid.key.KeyNotValidException
import io.mgfirefox.optional.Optional
import io.mgfirefox.stream.element.DefaultElementStream
import io.mgfirefox.stream.element.pair.DefaultPairStream

class LinkedHashMap<KeyT, ValueT>(map: KCReadOnlyMap<KeyT, ValueT>) : Map<KeyT, ValueT> {

    private val map: KCLinkedHashMap<KeyT, ValueT> = KCLinkedHashMap(map)

    override val count: Int
        get() = map.size

    override val keys: ReadOnlySet<KeyT>
        get() = LinkedHashSet(map.keys)
    override val values: ReadOnlyCollection<ValueT>
        get() = DefaultElementStream(map.values).toArrayList()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other !is Map<*, *>) {
            return false
        }

        if (map != other.unwrapMap()) {
            return false
        }

        return true
    }

    override fun hashCode(): Int {
        return map.hashCode()
    }

    override fun get(key: KeyT): ValueT {
        if (!containsKey(key)) {
            throw KeyNotValidException(key, keys)
        }

        return map[key]!!
    }

    override fun set(key: KeyT, value: ValueT) {
        map[key] = value
    }

    override fun contains(element: Pair<KeyT, ValueT>): Boolean {
        if (!containsKey(element.first)) {
            return false
        }

        if (element.second != this[element.first]) {
            return false
        }

        return true
    }

    override fun getIterator(): Iterator<Pair<KeyT, ValueT>> {
        return MapPairIterator(map.iterator())
    }

    override fun containsKey(key: KeyT): Boolean {
        return map.containsKey(key)
    }

    override fun containsValue(value: ValueT): Boolean {
        return map.containsValue(value)
    }

    override fun add(element: Pair<KeyT, ValueT>) {
        this[element.first] = element.second
    }

    override fun remove(element: Pair<KeyT, ValueT>): Boolean {
        val isElementRemoved = discardBy(element.first)

        return isElementRemoved
    }

    override fun discardBy(key: KeyT): Boolean {
        val removedValue: Optional<ValueT> = removeBy(key)

        val isElementDiscarded = removedValue.hasValue

        return isElementDiscarded
    }

    override fun removeBy(key: KeyT): Optional<ValueT> {
        if (!containsKey(key)) {
            return Optional.ofEmpty()
        }

        val removedValue: ValueT = map.remove(key)!!

        return Optional.of(removedValue)
    }

    override fun clear() {
        map.clear()
    }

    override fun unwrapWriteOnlyIterable(): KCWriteOnlyIterable<Pair<KeyT, ValueT>> {
        return unwrapCollection()
    }

    override fun unwrapReadOnlyCollection(): KCReadOnlyCollection<Pair<KeyT, ValueT>> {
        return unwrapCollection()
    }

    override fun unwrapWriteOnlyCollection(): KCWriteOnlyCollection<Pair<KeyT, ValueT>> {
        return unwrapCollection()
    }

    override fun unwrapCollection(): KCCollection<Pair<KeyT, ValueT>> {
        val collection = LinkedHashMapCollection(map.entries)

        return collection
    }

    override fun unwrapReadOnlyMap(): KCReadOnlyMap<KeyT, ValueT> {
        return unwrapMap()
    }

    override fun unwrapWriteOnlyMap(): KCWriteOnlyMap<KeyT, ValueT> {
        return unwrapMap()
    }

    override fun unwrapMap(): KCMap<KeyT, ValueT> {
        return unwrapLinkedHashMap()
    }

    fun unwrapLinkedHashMap(): KCLinkedHashMap<KeyT, ValueT> {
        return KCLinkedHashMap(map)
    }

    override fun toString(): String {
        return map.toString()
    }

    companion object {

        @JvmStatic
        fun <KeyT, ValueT> of(vararg elements: Pair<KeyT, ValueT>): LinkedHashMap<KeyT, ValueT> {
            val array = TypedArray.of(*elements)

            return DefaultPairStream(array).toLinkedHashMap()
        }

        @JvmStatic
        fun <KeyT, ValueT> from(
            iterable: ReadOnlyIterable<Pair<KeyT, ValueT>>
        ): LinkedHashMap<KeyT, ValueT> {
            return DefaultPairStream(iterable).toLinkedHashMap()
        }
    }
}

private class LinkedHashMapCollection<KeyT, ValueT>(
    mapEntries: KCReadOnlySet<KCMapEntry<KeyT, ValueT>>
) : KCCollection<Pair<KeyT, ValueT>> {

    private val set: KCLinkedHashSet<Pair<KeyT, ValueT>> =
        DefaultElementStream(mapEntries).mapToPair { mapEntry ->
            Pair.fromMapEntry(mapEntry)
        }.toLinkedHashSet().unwrapLinkedHashSet()

    override val size: Int
        get() = set.size

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other !is KCSet<*>) {
            return false
        }

        if (set != other) {
            return false
        }

        return true
    }

    override fun hashCode(): Int {
        return set.hashCode()
    }

    override fun contains(element: Pair<KeyT, ValueT>): Boolean {
        return element in set
    }

    override fun containsAll(elements: KCReadOnlyCollection<Pair<KeyT, ValueT>>): Boolean {
        return set.containsAll(elements)
    }

    override fun isEmpty(): Boolean {
        return set.isEmpty()
    }

    override fun iterator(): KCIterator<Pair<KeyT, ValueT>> {
        return set.iterator()
    }

    override fun add(element: Pair<KeyT, ValueT>): Boolean {
        for (pair in set) {
            if (pair.first != element.first) {
                continue
            }

            set.remove(pair)

            break
        }

        return set.add(element)
    }

    override fun addAll(elements: KCReadOnlyCollection<Pair<KeyT, ValueT>>): Boolean {
        return set.addAll(elements)
    }

    override fun remove(element: Pair<KeyT, ValueT>): Boolean {
        return set.remove(element)
    }

    @Suppress("ConvertArgumentToSet")
    override fun removeAll(elements: KCReadOnlyCollection<Pair<KeyT, ValueT>>): Boolean {
        return set.removeAll(elements)
    }

    @Suppress("ConvertArgumentToSet")
    override fun retainAll(elements: KCReadOnlyCollection<Pair<KeyT, ValueT>>): Boolean {
        return set.retainAll(elements)
    }

    override fun clear() {
        set.clear()
    }
}