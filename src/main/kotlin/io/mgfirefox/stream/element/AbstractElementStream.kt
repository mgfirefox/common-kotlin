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
import io.mgfirefox.stream.Stream
import io.mgfirefox.stream.element.iterable.IterableStream
import io.mgfirefox.stream.element.pair.PairStream

abstract class AbstractElementStream<ElementT> protected constructor(
    private val stream: KCStream<ElementT>
) : ElementStream<ElementT> {

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

    override fun <ResultT> mapToIterable(
        mapper: Mapper<ElementT, ReadOnlyIterable<ResultT>>
    ): IterableStream<ResultT> {
        return createIterable(map(mapper).unwrapStream())
    }

    override fun <OtherT> zip(other: Stream<OtherT>): PairStream<ElementT, OtherT> {
        val pairStream = create(stream.zip(other.unwrapStream())).mapToPair { pair -> Pair(pair) }

        return pairStream
    }

    override fun filter(predicate: Predicate<ElementT>): ElementStream<ElementT> {
        return create(stream.filter(predicate))
    }

    override fun exclude(predicate: Predicate<ElementT>): ElementStream<ElementT> {
        val streamWithExcludedElements = stream.filterNot(predicate)

        return create(streamWithExcludedElements)
    }

    override fun distinct(): ElementStream<ElementT> {
        return create(stream.distinct())
    }

    override fun take(count: Int): ElementStream<ElementT> {
        return create(stream.take(count))
    }

    override fun takeWhile(predicate: Predicate<ElementT>): ElementStream<ElementT> {
        return create(stream.takeWhile(predicate))
    }

    override fun takeUntil(predicate: Predicate<ElementT>): ElementStream<ElementT> {
        val stream = takeWhile { element -> !predicate(element) }

        return stream
    }

    override fun drop(count: Int): ElementStream<ElementT> {
        return create(stream.drop(count))
    }

    override fun dropWhile(predicate: Predicate<ElementT>): ElementStream<ElementT> {
        return create(stream.dropWhile(predicate))
    }

    override fun dropUntil(predicate: Predicate<ElementT>): ElementStream<ElementT> {
        val stream = dropWhile { element -> !predicate(element) }

        return stream
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