package io.mgfirefox.collection.array

import io.mgfirefox.`object`.accessor.index.IndexAccessor

interface Array<ElementT> : IndexAccessor<ElementT>, ReadOnlyArray<ElementT>,
    WriteOnlyArray<ElementT> {

    fun unwrapArray(): KArray<ElementT>
}