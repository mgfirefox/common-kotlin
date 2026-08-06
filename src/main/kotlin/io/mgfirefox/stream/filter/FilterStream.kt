package io.mgfirefox.stream.filter

import io.mgfirefox.stream.Stream

interface FilterStream<out ElementT> : Stream<ElementT> {

    fun filter(predicate: FilterPredicate<ElementT>): FilterStream<ElementT>
    fun exclude(predicate: ExcludePredicate<ElementT>): FilterStream<ElementT>
}