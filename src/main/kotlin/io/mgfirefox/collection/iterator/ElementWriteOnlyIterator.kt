package io.mgfirefox.collection.iterator

class ElementWriteOnlyIterator<in ElementT>(private val iterator: KCWriteOnlyIterator<ElementT>) :
    WriteOnlyIterator<ElementT> {

    override fun advance(): Boolean {
        if (!iterator.hasNext()) {
            return false
        }

        iterator.next()

        return true
    }

    override fun remove() {
        iterator.remove()
    }

    override fun unwrapWriteOnlyIterator(): KCWriteOnlyIterator<ElementT> {
        return iterator
    }
}