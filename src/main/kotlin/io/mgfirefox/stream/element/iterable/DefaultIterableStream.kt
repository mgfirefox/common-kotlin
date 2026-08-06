package io.mgfirefox.stream.element.iterable

import io.mgfirefox.collection.array.KReadOnlyArray
import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.stream.KCStream
import io.mgfirefox.stream.Stream
import io.mgfirefox.stream.element.DefaultElementStream
import io.mgfirefox.stream.element.ElementStream
import io.mgfirefox.stream.filter.ExcludePredicate
import io.mgfirefox.stream.filter.FilterPredicate

class DefaultIterableStream<ElementT>(private val stream: KCStream<ReadOnlyIterable<ElementT>>) :
    DefaultElementStream<ReadOnlyIterable<ElementT>>(stream), IterableStream<ElementT> {

    override fun flatten(): ElementStream<ElementT> {
        return DefaultElementStream(stream.flatten())
    }

    override fun filter(
        predicate: FilterPredicate<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT> {
        return from(super.filter(predicate))
    }

    override fun exclude(
        predicate: ExcludePredicate<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT> {
        return from(super.exclude(predicate))
    }

    override fun reverse(): IterableStream<ElementT> {
        return from(super.reverse())
    }

    override fun shuffle(): IterableStream<ElementT> {
        return from(super.shuffle())
    }

    companion object {

        @JvmStatic
        fun <ElementT> from(
            stream: Stream<ReadOnlyIterable<ElementT>>
        ): DefaultIterableStream<ElementT> {
            return DefaultIterableStream(stream.unwrapStream())
        }
    }
}