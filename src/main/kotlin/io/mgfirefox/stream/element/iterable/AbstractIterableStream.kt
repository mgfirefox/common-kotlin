package io.mgfirefox.stream.element.iterable

import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.data.pair.Pair
import io.mgfirefox.function.predicate.Predicate
import io.mgfirefox.stream.KCStream
import io.mgfirefox.stream.element.AbstractElementStream
import io.mgfirefox.stream.element.ElementStream
import io.mgfirefox.stream.element.pair.PairStream

abstract class AbstractIterableStream<ElementT> protected constructor(
    private val stream: KCStream<ReadOnlyIterable<ElementT>>
) : AbstractElementStream<ReadOnlyIterable<ElementT>>(stream), IterableStream<ElementT> {

    override fun flatten(): ElementStream<ElementT> {
        return create(stream.flatten())
    }

    override fun filter(
        predicate: Predicate<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT> {
        return createDerived(this.filter(predicate))
    }

    override fun exclude(
        predicate: Predicate<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT> {
        return createDerived(this.exclude(predicate))
    }

    override fun distinct(): IterableStream<ElementT> {
        return createDerived(this.distinct())
    }

    override fun take(count: Int): IterableStream<ElementT> {
        return createDerived(this.take(count))
    }

    override fun takeWhile(
        predicate: Predicate<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT> {
        return createDerived(this.takeWhile(predicate))
    }

    override fun takeUntil(
        predicate: Predicate<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT> {
        return createDerived(this.takeUntil(predicate))
    }

    override fun drop(count: Int): IterableStream<ElementT> {
        return createDerived(this.drop(count))
    }

    override fun dropWhile(
        predicate: Predicate<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT> {
        return createDerived(this.dropWhile(predicate))
    }

    override fun dropUntil(
        predicate: Predicate<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT> {
        return createDerived(this.dropUntil(predicate))
    }

    override fun reverse(): IterableStream<ElementT> {
        return createDerived(this.reverse())
    }

    override fun shuffle(): IterableStream<ElementT> {
        return createDerived(this.shuffle())
    }

    abstract override fun createDerived(
        stream: ElementStream<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT>

    abstract override fun <ElementT> create(stream: KCStream<ElementT>): ElementStream<ElementT>

    abstract override fun <FirstT, SecondT> createPair(
        stream: KCStream<Pair<FirstT, SecondT>>
    ): PairStream<FirstT, SecondT>

    abstract override fun <ElementT> createIterable(
        stream: KCStream<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT>
}