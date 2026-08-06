package io.mgfirefox.collection.iterator

interface WriteOnlyIterator<in ElementT> {

    fun advance(): Boolean

    fun remove()

    fun unwrapWriteOnlyIterator(): KCWriteOnlyIterator<ElementT>
}