package io.mgfirefox.collection

import io.mgfirefox.collection.iterable.Iterable

interface Collection<ElementT> : Iterable<ElementT>, ReadOnlyCollection<ElementT>,
    WriteOnlyCollection<ElementT> {

    fun unwrapCollection(): KCCollection<ElementT>
}