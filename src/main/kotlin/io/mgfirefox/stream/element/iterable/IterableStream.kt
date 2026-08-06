package io.mgfirefox.stream.element.iterable

import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.stream.element.ElementStream
import io.mgfirefox.stream.filter.ExcludePredicate
import io.mgfirefox.stream.filter.FilterPredicate
import io.mgfirefox.stream.filter.iterable.IterableFilterStream
import io.mgfirefox.stream.order.iterable.IterableOrderStream
import io.mgfirefox.stream.transform.iterable.IterableTransformStream

interface IterableStream<ElementT> : ElementStream<ReadOnlyIterable<ElementT>>,
    IterableTransformStream<ElementT>, IterableFilterStream<ElementT>,
    IterableOrderStream<ElementT> {

    override fun flatten(): ElementStream<ElementT>

    override fun filter(
        predicate: FilterPredicate<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT>

    override fun exclude(
        predicate: ExcludePredicate<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT>

    override fun reverse(): IterableStream<ElementT>

    override fun shuffle(): IterableStream<ElementT>
}