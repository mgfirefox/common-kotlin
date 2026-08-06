package io.mgfirefox.collection.iterable

import io.mgfirefox.collection.iterator.WriteOnlyIterator

interface WriteOnlyIterable<in ElementT> {

    fun getIterator(): WriteOnlyIterator<ElementT>

    fun unwrapWriteOnlyIterable(): KCWriteOnlyIterable<ElementT>
}