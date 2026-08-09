package io.mgfirefox.stream.transform

import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.data.pair.Pair
import io.mgfirefox.function.mapper.Mapper
import io.mgfirefox.stream.Stream

interface TransformStream<ElementT> : Stream<ElementT> {

    fun <ResultT> map(mapper: Mapper<ElementT, ResultT>): TransformStream<ResultT>

    fun <FirstT, SecondT> mapToPair(
        mapper: Mapper<ElementT, Pair<FirstT, SecondT>>
    ): TransformStream<Pair<FirstT, SecondT>>

    fun <FirstT, SecondT> mapToPair(
        firstMapper: Mapper<ElementT, FirstT>, secondMapper: Mapper<ElementT, SecondT>
    ): TransformStream<Pair<FirstT, SecondT>>

    fun mapToIterable(
        mapper: Mapper<ElementT, ReadOnlyIterable<ElementT>>
    ): TransformStream<ReadOnlyIterable<ElementT>>

    fun <OtherT> zip(other: ReadOnlyIterable<OtherT>): TransformStream<Pair<ElementT, OtherT>>
}