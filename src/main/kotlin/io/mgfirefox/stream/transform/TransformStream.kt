package io.mgfirefox.stream.transform

import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.data.pair.Pair
import io.mgfirefox.function.mapper.Mapper
import io.mgfirefox.stream.Stream
import io.mgfirefox.stream.transform.iterable.IterableTransformStream
import io.mgfirefox.stream.transform.pair.PairTransformStream

interface TransformStream<out ElementT> : Stream<ElementT> {

    fun <ResultT> map(mapper: Mapper<ElementT, ResultT>): TransformStream<ResultT>

    fun <FirstT, SecondT> mapToPair(
        mapper: Mapper<ElementT, Pair<FirstT, SecondT>>
    ): PairTransformStream<FirstT, SecondT>

    fun <FirstT, SecondT> mapToPair(
        firstMapper: Mapper<ElementT, FirstT>, secondMapper: Mapper<ElementT, SecondT>
    ): PairTransformStream<FirstT, SecondT>

    fun <ResultT> mapToIterable(
        mapper: Mapper<ElementT, ReadOnlyIterable<ResultT>>
    ): IterableTransformStream<ResultT>

    fun <OtherT> zip(other: Stream<OtherT>): PairTransformStream<ElementT, OtherT>
}