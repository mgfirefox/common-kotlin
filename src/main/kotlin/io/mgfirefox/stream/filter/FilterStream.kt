package io.mgfirefox.stream.filter

import io.mgfirefox.function.predicate.Predicate
import io.mgfirefox.stream.Stream

interface FilterStream<out ElementT> : Stream<ElementT> {

    fun filter(predicate: Predicate<ElementT>): FilterStream<ElementT>
    fun exclude(predicate: Predicate<ElementT>): FilterStream<ElementT>
}