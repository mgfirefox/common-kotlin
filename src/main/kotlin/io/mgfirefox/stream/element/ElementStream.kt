package io.mgfirefox.stream.element

import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.data.pair.Pair
import io.mgfirefox.function.mapper.Mapper
import io.mgfirefox.function.predicate.Predicate
import io.mgfirefox.stream.Stream
import io.mgfirefox.stream.convert.ConvertStream
import io.mgfirefox.stream.element.iterable.IterableStream
import io.mgfirefox.stream.element.pair.PairStream
import io.mgfirefox.stream.filter.FilterStream
import io.mgfirefox.stream.order.OrderStream
import io.mgfirefox.stream.transform.TransformStream

interface ElementStream<ElementT> : Stream<ElementT>, TransformStream<ElementT>,
    FilterStream<ElementT>, OrderStream<ElementT>, ConvertStream<ElementT> {

    override fun <ResultT> map(mapper: Mapper<ElementT, ResultT>): ElementStream<ResultT>
    override fun <FirstT, SecondT> mapToPair(
        mapper: Mapper<ElementT, Pair<FirstT, SecondT>>
    ): PairStream<FirstT, SecondT>

    override fun <FirstT, SecondT> mapToPair(
        firstMapper: Mapper<ElementT, FirstT>, secondMapper: Mapper<ElementT, SecondT>
    ): PairStream<FirstT, SecondT>

    override fun mapToIterable(
        mapper: Mapper<ElementT, ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT>

    override fun <OtherT> zip(other: ReadOnlyIterable<OtherT>): PairStream<ElementT, OtherT>

    override fun filter(predicate: Predicate<ElementT>): ElementStream<ElementT>
    override fun exclude(predicate: Predicate<ElementT>): ElementStream<ElementT>
    
    override fun take(count: Int): ElementStream<ElementT>
    override fun takeWhile(predicate: Predicate<ElementT>): ElementStream<ElementT>
    override fun takeUntil(predicate: Predicate<ElementT>): ElementStream<ElementT>

    override fun drop(count: Int): ElementStream<ElementT>
    override fun dropWhile(predicate: Predicate<ElementT>): ElementStream<ElementT>
    override fun dropUntil(predicate: Predicate<ElementT>): ElementStream<ElementT>

    override fun reverse(): ElementStream<ElementT>

    override fun shuffle(): ElementStream<ElementT>
}