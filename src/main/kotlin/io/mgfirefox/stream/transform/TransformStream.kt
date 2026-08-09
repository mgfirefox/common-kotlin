package io.mgfirefox.stream.transform

import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.data.pair.Pair
import io.mgfirefox.stream.Stream

interface TransformStream<ElementT> : Stream<ElementT> {

    fun <ResultT> map(mapper: TransformMapper<ElementT, ResultT>): TransformStream<ResultT>

    fun <FirstT, SecondT> mapToPair(
        mapper: TransformMapper<ElementT, Pair<FirstT, SecondT>>
    ): TransformStream<Pair<FirstT, SecondT>>

    fun <FirstT, SecondT> mapToPair(
        firstMapper: TransformMapper<ElementT, FirstT>, secondMapper: TransformMapper<ElementT, SecondT>
    ): TransformStream<Pair<FirstT, SecondT>>

    fun mapToIterable(
        mapper: TransformMapper<ElementT, ReadOnlyIterable<ElementT>>
    ): TransformStream<ReadOnlyIterable<ElementT>>

    fun <OtherT> zip(other: ReadOnlyIterable<OtherT>): TransformStream<Pair<ElementT, OtherT>>
}