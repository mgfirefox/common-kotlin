package io.mgfirefox.stream.element.pair

import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.collection.map.KCReadOnlyMap
import io.mgfirefox.collection.map.LinkedHashMap
import io.mgfirefox.data.pair.Pair
import io.mgfirefox.function.predicate.Predicate
import io.mgfirefox.stream.KCStream
import io.mgfirefox.stream.element.AbstractElementStream
import io.mgfirefox.stream.element.ElementStream
import io.mgfirefox.stream.element.iterable.IterableStream

abstract class AbstractPairStream<FirstT, SecondT> protected constructor(
    stream: KCStream<Pair<FirstT, SecondT>>
) : AbstractElementStream<Pair<FirstT, SecondT>>(stream), PairStream<FirstT, SecondT> {

    override fun filter(predicate: Predicate<Pair<FirstT, SecondT>>): PairStream<FirstT, SecondT> {
        return createDerived(this.filter(predicate))
    }

    override fun exclude(predicate: Predicate<Pair<FirstT, SecondT>>): PairStream<FirstT, SecondT> {
        return createDerived(this.exclude(predicate))
    }

    override fun distinct(): PairStream<FirstT, SecondT> {
        return createDerived(this.distinct())
    }

    override fun take(count: Int): PairStream<FirstT, SecondT> {
        return createDerived(this.take(count))
    }

    override fun takeWhile(
        predicate: Predicate<Pair<FirstT, SecondT>>
    ): PairStream<FirstT, SecondT> {
        return createDerived(this.takeWhile(predicate))
    }

    override fun takeUntil(
        predicate: Predicate<Pair<FirstT, SecondT>>
    ): PairStream<FirstT, SecondT> {
        return createDerived(this.takeUntil(predicate))
    }

    override fun drop(count: Int): PairStream<FirstT, SecondT> {
        return createDerived(this.drop(count))
    }

    override fun dropWhile(
        predicate: Predicate<Pair<FirstT, SecondT>>
    ): PairStream<FirstT, SecondT> {
        return createDerived(this.dropWhile(predicate))
    }

    override fun dropUntil(
        predicate: Predicate<Pair<FirstT, SecondT>>
    ): PairStream<FirstT, SecondT> {
        return createDerived(this.dropUntil(predicate))
    }

    override fun reverse(): PairStream<FirstT, SecondT> {
        return createDerived(this.reverse())
    }

    override fun shuffle(): PairStream<FirstT, SecondT> {
        return createDerived(this.shuffle())
    }

    override fun toLinkedHashMap(): LinkedHashMap<FirstT, SecondT> {
        val map: KCReadOnlyMap<FirstT, SecondT> =
            map { pair -> pair.unwrapPair() }.unwrapStream().toMap()

        return LinkedHashMap(map)
    }

    abstract override fun createDerived(
        stream: ElementStream<Pair<FirstT, SecondT>>
    ): PairStream<FirstT, SecondT>

    abstract override fun <ElementT> create(stream: KCStream<ElementT>): ElementStream<ElementT>

    abstract override fun <FirstT, SecondT> createPair(
        stream: KCStream<Pair<FirstT, SecondT>>
    ): PairStream<FirstT, SecondT>

    abstract override fun <ElementT> createIterable(
        stream: KCStream<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT>
}