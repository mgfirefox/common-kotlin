package io.mgfirefox.collection.iterator

interface ReadOnlyIterator<out ElementT> : KCReadOnlyIterator<ElementT> {

    override fun hasNext(): Boolean
    fun getNext(): ElementT

    override fun next(): ElementT {
        return getNext()
    }
}