package io.mgfirefox.stream.element.iterable

import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.data.pair.Pair
import io.mgfirefox.stream.KCStream
import io.mgfirefox.stream.element.AbstractElementStream
import io.mgfirefox.stream.element.DefaultElementStream
import io.mgfirefox.stream.element.ElementStream
import io.mgfirefox.stream.element.pair.DefaultPairStream
import io.mgfirefox.stream.element.pair.PairStream
import io.mgfirefox.stream.filter.ExcludePredicate
import io.mgfirefox.stream.filter.FilterPredicate

class DefaultIterableStream<ElementT>(private val stream: KCStream<ReadOnlyIterable<ElementT>>) :
    AbstractElementStream<ReadOnlyIterable<ElementT>>(stream), IterableStream<ElementT> {

    override fun flatten(): ElementStream<ElementT> {
        return DefaultElementStream(stream.flatten())
    }

    override fun filter(
        predicate: FilterPredicate<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT> {
        return createDerived(super.filter(predicate))
    }

    override fun exclude(
        predicate: ExcludePredicate<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT> {
        return createDerived(super.exclude(predicate))
    }

    override fun reverse(): IterableStream<ElementT> {
        return createDerived(super.reverse())
    }

    override fun shuffle(): IterableStream<ElementT> {
        return createDerived(super.shuffle())
    }

    override fun createDerived(
        stream: ElementStream<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT> {
        return createIterable(stream.unwrapStream())
    }

    override fun <ElementT> create(stream: KCStream<ElementT>): ElementStream<ElementT> {
        return DefaultElementStream(stream)
    }

    override fun <KeyT, ValueT> createPair(
        stream: KCStream<Pair<KeyT, ValueT>>
    ): PairStream<KeyT, ValueT> {
        return DefaultPairStream(stream)
    }

    override fun <ElementT> createIterable(
        stream: KCStream<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT> {
        return DefaultIterableStream(stream)
    }
}