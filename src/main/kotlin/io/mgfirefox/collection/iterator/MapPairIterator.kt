package io.mgfirefox.collection.iterator

import io.mgfirefox.collection.map.KCMapEntry
import io.mgfirefox.data.pair.Pair

class MapPairIterator<KeyT, ValueT>(
    private val iterator: KCIterator<KCMapEntry<KeyT, ValueT>>
) : Iterator<Pair<KeyT, ValueT>> {

    override fun hasNext(): Boolean {
        return iterator.hasNext()
    }

    override fun getNext(): Pair<KeyT, ValueT> {
        val nextEntry: KCMapEntry<KeyT, ValueT> = iterator.next()

        return Pair(nextEntry.key, nextEntry.value)
    }

    override fun advance(): Boolean {
        if (!hasNext()) {
            return false
        }

        getNext()

        return true
    }

    override fun remove() {
        iterator.remove()
    }

    override fun unwrapWriteOnlyIterator(): KCWriteOnlyIterator<*> {
        return iterator
    }
}