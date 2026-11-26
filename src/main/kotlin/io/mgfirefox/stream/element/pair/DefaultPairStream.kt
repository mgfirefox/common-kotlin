package io.mgfirefox.stream.element.pair

import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.data.pair.Pair
import io.mgfirefox.stream.KCStream
import io.mgfirefox.stream.element.DefaultElementStream
import io.mgfirefox.stream.element.ElementStream
import io.mgfirefox.stream.element.iterable.DefaultIterableStream
import io.mgfirefox.stream.element.iterable.IterableStream

class DefaultPairStream<FirstT, SecondT>(stream: KCStream<Pair<FirstT, SecondT>>) :
    AbstractPairStream<FirstT, SecondT>(stream) {

    override fun createDerived(
        stream: ElementStream<Pair<FirstT, SecondT>>
    ): PairStream<FirstT, SecondT> {
        return createPair(stream.unwrapStream())
    }

    override fun <ElementT> create(stream: KCStream<ElementT>): ElementStream<ElementT> {
        return DefaultElementStream(stream)
    }

    override fun <FirstT, SecondT> createPair(
        stream: KCStream<Pair<FirstT, SecondT>>
    ): PairStream<FirstT, SecondT> {
        return DefaultPairStream(stream)
    }

    override fun <ElementT> createIterable(
        stream: KCStream<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT> {
        return DefaultIterableStream(stream)
    }
}