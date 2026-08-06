package io.mgfirefox.collection.array

import io.mgfirefox.collection.ReadOnlyCollection
import io.mgfirefox.`object`.accessor.index.ReadOnlyIndexAccessor
import io.mgfirefox.optional.Optional

interface ReadOnlyArray<out ElementT> : ReadOnlyCollection<ElementT>,
    ReadOnlyIndexAccessor<ElementT> {

    fun getIndexOf(element: @UnsafeVariance ElementT): Optional<Int>
    fun getLastIndexOf(element: @UnsafeVariance ElementT): Optional<Int>

    fun unwrapReadOnlyArray(): KReadOnlyArray<ElementT>
}