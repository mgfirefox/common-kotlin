package io.mgfirefox.collection.list

import io.mgfirefox.collection.ReadOnlyCollection
import io.mgfirefox.`object`.accessor.index.ReadOnlyIndexAccessor
import io.mgfirefox.optional.Optional

interface ReadOnlyList<out ElementT> : ReadOnlyCollection<ElementT>,
    ReadOnlyIndexAccessor<ElementT> {

    fun getIndexOf(element: @UnsafeVariance ElementT): Optional<Int>
    fun getLastIndexOf(element: @UnsafeVariance ElementT): Optional<Int>

    fun unwrapReadOnlyList(): KCReadOnlyList<ElementT>
}