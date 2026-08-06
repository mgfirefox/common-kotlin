package io.mgfirefox.stream.transform

import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.data.pair.Pair
import io.mgfirefox.stream.Stream

interface TransformStream<ElementT> : Stream<ElementT> {

    fun <ResultT> map(mapper: TransformMapper<ElementT, ResultT>): TransformStream<ResultT>

    fun <KeyT, ValueT> mapToPair(
        mapper: TransformMapper<ElementT, Pair<KeyT, ValueT>>
    ): TransformStream<Pair<KeyT, ValueT>>

    fun <KeyT, ValueT> mapToPair(
        keyMapper: TransformMapper<ElementT, KeyT>, valueMapper: TransformMapper<ElementT, ValueT>
    ): TransformStream<Pair<KeyT, ValueT>>

    fun mapToIterable(
        mapper: TransformMapper<ElementT, ReadOnlyIterable<ElementT>>
    ): TransformStream<ReadOnlyIterable<ElementT>>

    fun <OtherT> zip(other: ReadOnlyIterable<OtherT>): TransformStream<Pair<ElementT, OtherT>>
}