package io.mgfirefox.collection.iterable

import io.mgfirefox.collection.iterator.KCReadOnlyIterator
import io.mgfirefox.collection.iterator.ReadOnlyIterator

interface ReadOnlyIterable<out ElementT> : KCReadOnlyIterable<ElementT> {

    fun getIterator(): ReadOnlyIterator<ElementT>

    override fun iterator(): KCReadOnlyIterator<ElementT> {
        return getIterator()
    }
}