package io.mgfirefox.collection.iterator

class ElementIterator<ElementT>(private val iterator: KCIterator<ElementT>) : Iterator<ElementT> {

    override fun hasNext(): Boolean {
        return iterator.hasNext()
    }

    override fun getNext(): ElementT {
        return iterator.next()
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

    override fun unwrapWriteOnlyIterator(): KCWriteOnlyIterator<ElementT> {
        return iterator
    }
}