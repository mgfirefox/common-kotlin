package io.mgfirefox.collection.set

import io.mgfirefox.collection.Collection

interface Set<ElementT> : Collection<ElementT>, ReadOnlySet<ElementT>, WriteOnlySet<ElementT> {

    fun unwrapSet(): KCSet<ElementT>
}