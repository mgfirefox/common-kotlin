package io.mgfirefox.stream.filter.iterable

import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.function.predicate.Predicate
import io.mgfirefox.stream.filter.FilterStream

interface IterableFilterStream<ElementT> : FilterStream<ReadOnlyIterable<ElementT>> {

    override fun filter(
        predicate: Predicate<ReadOnlyIterable<ElementT>>
    ): IterableFilterStream<ElementT>

    override fun exclude(
        predicate: Predicate<ReadOnlyIterable<ElementT>>
    ): IterableFilterStream<ElementT>
}