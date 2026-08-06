package io.mgfirefox.collection.iterator

class ElementReadOnlyIterator<out ElementT>(private val iterator: KCReadOnlyIterator<ElementT>) :
    ReadOnlyIterator<ElementT> {

    override fun hasNext(): Boolean {
        return iterator.hasNext()
    }

    override fun getNext(): ElementT {
        return iterator.next()
    }
}