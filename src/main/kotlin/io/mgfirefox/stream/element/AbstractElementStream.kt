package io.mgfirefox.stream.element

import io.mgfirefox.collection.array.TypedArray
import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.collection.list.ArrayList
import io.mgfirefox.collection.list.KCReadOnlyList
import io.mgfirefox.collection.set.KCReadOnlySet
import io.mgfirefox.collection.set.LinkedHashSet
import io.mgfirefox.data.pair.Pair
import io.mgfirefox.stream.KCStream
import io.mgfirefox.stream.element.iterable.IterableStream
import io.mgfirefox.stream.element.pair.PairStream
import io.mgfirefox.stream.filter.ExcludePredicate
import io.mgfirefox.stream.filter.FilterPredicate
import io.mgfirefox.stream.transform.TransformMapper

abstract class AbstractElementStream<ElementT>(private val stream: KCStream<ElementT>) :
    ElementStream<ElementT> {

    override fun <ResultT> map(mapper: TransformMapper<ElementT, ResultT>): ElementStream<ResultT> {
        return create(stream.map(mapper))
    }

    override fun <KeyT, ValueT> mapToPair(
        mapper: TransformMapper<ElementT, Pair<KeyT, ValueT>>
    ): PairStream<KeyT, ValueT> {
        return createPair(map(mapper).unwrapStream())
    }

    override fun <KeyT, ValueT> mapToPair(
        keyMapper: TransformMapper<ElementT, KeyT>, valueMapper: TransformMapper<ElementT, ValueT>
    ): PairStream<KeyT, ValueT> {
        val pairStream = mapToPair { element -> Pair(keyMapper(element), valueMapper(element)) }

        return pairStream
    }

    override fun mapToIterable(
        mapper: TransformMapper<ElementT, ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT> {
        return createIterable(map(mapper).unwrapStream())
    }

    override fun <OtherT> zip(other: ReadOnlyIterable<OtherT>): PairStream<ElementT, OtherT> {
        val pairStream = DefaultElementStream(stream.zip(other)).mapToPair { pair -> Pair(pair) }

        return pairStream
    }

    override fun filter(predicate: FilterPredicate<ElementT>): ElementStream<ElementT> {
        return create(stream.filter(predicate))
    }

    override fun exclude(predicate: ExcludePredicate<ElementT>): ElementStream<ElementT> {
        val streamWithExcludedElements = stream.filterNot(predicate)

        return create(streamWithExcludedElements)
    }

    override fun reverse(): ElementStream<ElementT> {
        return create(stream.reversed())
    }

    override fun shuffle(): ElementStream<ElementT> {
        return create(stream.shuffled())
    }

    override fun unwrapStream(): KCStream<ElementT> {
        return stream
    }

    override fun toTypedArray(): TypedArray<ElementT> {
        val count: Int = stream.count()
        val iterator: Iterator<ElementT> = stream.iterator()

        return TypedArray(count) { iterator.next() }
    }

    override fun toArrayList(): ArrayList<ElementT> {
        val list: KCReadOnlyList<ElementT> = stream.toList()

        return ArrayList(list)
    }

    override fun toLinkedHashSet(): LinkedHashSet<ElementT> {
        val set: KCReadOnlySet<ElementT> = stream.toSet()

        return LinkedHashSet(set)
    }

    protected abstract fun createDerived(stream: ElementStream<ElementT>): ElementStream<ElementT>

    protected abstract fun <ElementT> create(stream: KCStream<ElementT>): ElementStream<ElementT>

    protected abstract fun <KeyT, ValueT> createPair(
        stream: KCStream<Pair<KeyT, ValueT>>
    ): PairStream<KeyT, ValueT>

    protected abstract fun <ElementT> createIterable(
        stream: KCStream<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT>
}