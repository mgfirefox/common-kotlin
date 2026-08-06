package io.mgfirefox.collection.iterable

import io.mgfirefox.collection.iterator.Iterator
import io.mgfirefox.collection.iterator.KCIterator

interface Iterable<ElementT> : KCIterable<ElementT>, ReadOnlyIterable<ElementT>,
    WriteOnlyIterable<ElementT> {

    override fun getIterator(): Iterator<ElementT>

    override fun iterator(): KCIterator<ElementT> {
        return getIterator()
    }
}