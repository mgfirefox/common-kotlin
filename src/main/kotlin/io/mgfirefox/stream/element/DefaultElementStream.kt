package io.mgfirefox.stream.element

import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.data.pair.Pair
import io.mgfirefox.stream.KCStream
import io.mgfirefox.stream.element.iterable.DefaultIterableStream
import io.mgfirefox.stream.element.iterable.IterableStream
import io.mgfirefox.stream.element.pair.DefaultPairStream
import io.mgfirefox.stream.element.pair.PairStream

class DefaultElementStream<ElementT>(stream: KCStream<ElementT>) :
    AbstractElementStream<ElementT>(stream) {

    override fun createDerived(stream: ElementStream<ElementT>): ElementStream<ElementT> {
        return stream
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