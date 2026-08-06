package io.mgfirefox.stream.filter.iterable

import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.stream.filter.ExcludePredicate
import io.mgfirefox.stream.filter.FilterPredicate
import io.mgfirefox.stream.filter.FilterStream

interface IterableFilterStream<ElementT> : FilterStream<ReadOnlyIterable<ElementT>> {

    override fun filter(
        predicate: FilterPredicate<ReadOnlyIterable<ElementT>>
    ): IterableFilterStream<ElementT>

    override fun exclude(
        predicate: ExcludePredicate<ReadOnlyIterable<ElementT>>
    ): IterableFilterStream<ElementT>
}