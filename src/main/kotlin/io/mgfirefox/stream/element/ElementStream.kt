package io.mgfirefox.stream.element

import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.data.pair.Pair
import io.mgfirefox.stream.Stream
import io.mgfirefox.stream.convert.ConvertStream
import io.mgfirefox.stream.element.iterable.IterableStream
import io.mgfirefox.stream.element.pair.PairStream
import io.mgfirefox.stream.filter.ExcludePredicate
import io.mgfirefox.stream.filter.FilterPredicate
import io.mgfirefox.stream.filter.FilterStream
import io.mgfirefox.stream.order.OrderStream
import io.mgfirefox.stream.transform.TransformMapper
import io.mgfirefox.stream.transform.TransformStream

interface ElementStream<ElementT> : Stream<ElementT>, TransformStream<ElementT>,
    FilterStream<ElementT>, OrderStream<ElementT>, ConvertStream<ElementT> {

    override fun <ResultT> map(mapper: TransformMapper<ElementT, ResultT>): ElementStream<ResultT>
    override fun <FirstT, SecondT> mapToPair(
        mapper: TransformMapper<ElementT, Pair<FirstT, SecondT>>
    ): PairStream<FirstT, SecondT>

    override fun <FirstT, SecondT> mapToPair(
        firstMapper: TransformMapper<ElementT, FirstT>, secondMapper: TransformMapper<ElementT, SecondT>
    ): PairStream<FirstT, SecondT>

    override fun mapToIterable(
        mapper: TransformMapper<ElementT, ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT>

    override fun <OtherT> zip(other: ReadOnlyIterable<OtherT>): PairStream<ElementT, OtherT>

    override fun filter(predicate: FilterPredicate<ElementT>): ElementStream<ElementT>
    override fun exclude(predicate: ExcludePredicate<ElementT>): ElementStream<ElementT>

    override fun reverse(): ElementStream<ElementT>

    override fun shuffle(): ElementStream<ElementT>
}