package io.mgfirefox.collection.iterator

interface Iterator<ElementT> : KCIterator<ElementT>, ReadOnlyIterator<ElementT>,
    WriteOnlyIterator<ElementT>