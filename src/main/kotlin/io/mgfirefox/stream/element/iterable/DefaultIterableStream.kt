package io.mgfirefox.stream.element.iterable

import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.data.pair.Pair
import io.mgfirefox.stream.KCStream
import io.mgfirefox.stream.element.DefaultElementStream
import io.mgfirefox.stream.element.ElementStream
import io.mgfirefox.stream.element.pair.DefaultPairStream
import io.mgfirefox.stream.element.pair.PairStream

class DefaultIterableStream<ElementT>(stream: KCStream<ReadOnlyIterable<ElementT>>) :
    AbstractIterableStream<ElementT>(stream) {

    override fun createDerived(
        stream: ElementStream<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT> {
        return createIterable(stream.unwrapStream())
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