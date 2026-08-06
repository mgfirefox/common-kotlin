package io.mgfirefox.collection.list

import io.mgfirefox.collection.WriteOnlyCollection
import io.mgfirefox.`object`.accessor.index.WriteOnlyIndexAccessor

interface WriteOnlyList<ElementT> : WriteOnlyCollection<ElementT>,
    WriteOnlyIndexAccessor<ElementT> {

    fun insertAt(index: Int, element: ElementT)
    fun removeAt(index: Int): ElementT

    fun unwrapWriteOnlyList(): KCWriteOnlyList<ElementT>
}