package io.mgfirefox.stream.element

import io.mgfirefox.collection.array.TypedArray
import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.collection.list.ArrayList
import io.mgfirefox.collection.list.KCReadOnlyList
import io.mgfirefox.collection.set.KCReadOnlySet
import io.mgfirefox.collection.set.LinkedHashSet
import io.mgfirefox.data.pair.Pair
import io.mgfirefox.function.mapper.Mapper
import io.mgfirefox.function.predicate.Predicate
import io.mgfirefox.stream.KCStream
import io.mgfirefox.stream.element.iterable.IterableStream
import io.mgfirefox.stream.element.pair.PairStream

abstract class AbstractElementStream<ElementT>(private val stream: KCStream<ElementT>) :
    ElementStream<ElementT> {

    override fun <ResultT> map(mapper: Mapper<ElementT, ResultT>): ElementStream<ResultT> {
        return create(stream.map(mapper))
    }

    override fun <FirstT, SecondT> mapToPair(
        mapper: Mapper<ElementT, Pair<FirstT, SecondT>>
    ): PairStream<FirstT, SecondT> {
        return createPair(map(mapper).unwrapStream())
    }

    override fun <FirstT, SecondT> mapToPair(
        firstMapper: Mapper<ElementT, FirstT>, secondMapper: Mapper<ElementT, SecondT>
    ): PairStream<FirstT, SecondT> {
        val pairStream = mapToPair { element -> Pair(firstMapper(element), secondMapper(element)) }

        return pairStream
    }

    override fun mapToIterable(
        mapper: Mapper<ElementT, ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT> {
        return createIterable(map(mapper).unwrapStream())
    }

    override fun <OtherT> zip(other: ReadOnlyIterable<OtherT>): PairStream<ElementT, OtherT> {
        val pairStream = DefaultElementStream(stream.zip(other)).mapToPair { pair -> Pair(pair) }

        return pairStream
    }

    override fun filter(predicate: Predicate<ElementT>): ElementStream<ElementT> {
        return create(stream.filter(predicate))
    }

    override fun exclude(predicate: Predicate<ElementT>): ElementStream<ElementT> {
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

    protected abstract fun <FirstT, SecondT> createPair(
        stream: KCStream<Pair<FirstT, SecondT>>
    ): PairStream<FirstT, SecondT>

    protected abstract fun <ElementT> createIterable(
        stream: KCStream<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT>
}