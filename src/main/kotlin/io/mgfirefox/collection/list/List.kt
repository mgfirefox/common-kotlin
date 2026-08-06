package io.mgfirefox.collection.list

import io.mgfirefox.collection.Collection
import io.mgfirefox.`object`.accessor.index.IndexAccessor

interface List<ElementT> : Collection<ElementT>, IndexAccessor<ElementT>, ReadOnlyList<ElementT>,
    WriteOnlyList<ElementT> {

    fun unwrapList(): KCList<ElementT>
}