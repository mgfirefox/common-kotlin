package io.mgfirefox.stream.element.iterable

import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.function.predicate.Predicate
import io.mgfirefox.stream.convert.iterable.IterableConvertStream
import io.mgfirefox.stream.element.ElementStream
import io.mgfirefox.stream.filter.iterable.IterableFilterStream
import io.mgfirefox.stream.order.iterable.IterableOrderStream
import io.mgfirefox.stream.transform.iterable.IterableTransformStream

interface IterableStream<ElementT> : ElementStream<ReadOnlyIterable<ElementT>>,
    IterableTransformStream<ElementT>, IterableFilterStream<ElementT>,
    IterableOrderStream<ElementT>, IterableConvertStream<ElementT> {

    override fun flatten(): ElementStream<ElementT>

    override fun filter(
        predicate: Predicate<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT>

    override fun exclude(
        predicate: Predicate<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT>

    override fun distinct(): IterableStream<ElementT>

    override fun take(count: Int): IterableStream<ElementT>
    override fun takeWhile(
        predicate: Predicate<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT>

    override fun takeUntil(
        predicate: Predicate<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT>

    override fun drop(count: Int): IterableStream<ElementT>
    override fun dropWhile(
        predicate: Predicate<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT>

    override fun dropUntil(
        predicate: Predicate<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT>

    override fun reverse(): IterableStream<ElementT>

    override fun shuffle(): IterableStream<ElementT>
}