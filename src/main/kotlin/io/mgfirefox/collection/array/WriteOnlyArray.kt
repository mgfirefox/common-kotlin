package io.mgfirefox.collection.array

import io.mgfirefox.`object`.accessor.index.WriteOnlyIndexAccessor

interface WriteOnlyArray<in ElementT> : WriteOnlyIndexAccessor<ElementT> {

    fun unwrapWriteOnlyArray(): KWriteOnlyArray<in ElementT>
}