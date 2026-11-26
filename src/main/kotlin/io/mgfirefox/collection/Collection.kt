package io.mgfirefox.collection

import io.mgfirefox.collection.iterable.Iterable
import io.mgfirefox.`object`.equatable.Equatable

interface Collection<ElementT> : Iterable<ElementT>, ReadOnlyCollection<ElementT>,
    WriteOnlyCollection<ElementT> {

    fun unwrapCollection(): KCCollection<ElementT>
}