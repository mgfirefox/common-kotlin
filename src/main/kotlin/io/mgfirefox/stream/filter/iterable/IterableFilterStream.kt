package io.mgfirefox.stream.filter.iterable

import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.function.predicate.Predicate
import io.mgfirefox.stream.filter.FilterStream

interface IterableFilterStream<out ElementT> : FilterStream<ReadOnlyIterable<ElementT>> {

    override fun filter(
        predicate: Predicate<ReadOnlyIterable<ElementT>>
    ): IterableFilterStream<ElementT>

    override fun exclude(
        predicate: Predicate<ReadOnlyIterable<ElementT>>
    ): IterableFilterStream<ElementT>
    override fun distinct(): IterableFilterStream<ElementT>
    
    override fun take(count: Int): IterableFilterStream<ElementT>
    override fun takeWhile(predicate: Predicate<ReadOnlyIterable<ElementT>>): IterableFilterStream<ElementT>
    override fun takeUntil(predicate: Predicate<ReadOnlyIterable<ElementT>>): IterableFilterStream<ElementT>

    override fun drop(count: Int): IterableFilterStream<ElementT>
    override fun dropWhile(predicate: Predicate<ReadOnlyIterable<ElementT>>): IterableFilterStream<ElementT>
    override fun dropUntil(predicate: Predicate<ReadOnlyIterable<ElementT>>): IterableFilterStream<ElementT>
}