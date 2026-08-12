package io.mgfirefox.stream.element.pair

import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.collection.map.KCReadOnlyMap
import io.mgfirefox.collection.map.LinkedHashMap
import io.mgfirefox.data.pair.Pair
import io.mgfirefox.function.predicate.Predicate
import io.mgfirefox.stream.KCStream
import io.mgfirefox.stream.convert.pair.PairConvertStream
import io.mgfirefox.stream.element.AbstractElementStream
import io.mgfirefox.stream.element.DefaultElementStream
import io.mgfirefox.stream.element.ElementStream
import io.mgfirefox.stream.element.iterable.DefaultIterableStream
import io.mgfirefox.stream.element.iterable.IterableStream

class DefaultPairStream<FirstT, SecondT>(stream: KCStream<Pair<FirstT, SecondT>>) :
    AbstractElementStream<Pair<FirstT, SecondT>>(stream), PairStream<FirstT, SecondT> {

    override fun filter(predicate: Predicate<Pair<FirstT, SecondT>>): PairStream<FirstT, SecondT> {
        return createDerived(super.filter(predicate))
    }

    override fun exclude(predicate: Predicate<Pair<FirstT, SecondT>>): PairStream<FirstT, SecondT> {
        return createDerived(super.exclude(predicate))
    }

    override fun distinct(): PairStream<FirstT, SecondT> {
        return createDerived(super.distinct())
    }

    override fun take(count: Int): PairStream<FirstT, SecondT> {
        return createDerived(super.take(count))
    }
    
    override fun takeWhile(predicate: Predicate<Pair<FirstT, SecondT>>): PairStream<FirstT, SecondT> {
        return createDerived(super.takeWhile(predicate))
    }
    
    override fun takeUntil(predicate: Predicate<Pair<FirstT, SecondT>>): PairStream<FirstT, SecondT> {
        return createDerived(super.takeUntil(predicate))
    }

    override fun drop(count: Int): PairStream<FirstT, SecondT> {
        return createDerived(super.drop(count))
    }
    
    override fun dropWhile(predicate: Predicate<Pair<FirstT, SecondT>>): PairStream<FirstT, SecondT> {
        return createDerived(super.dropWhile(predicate))
    }
    
    override fun dropUntil(predicate: Predicate<Pair<FirstT, SecondT>>): PairStream<FirstT, SecondT> {
        return createDerived(super.dropUntil(predicate))
    }

    override fun reverse(): PairStream<FirstT, SecondT> {
        return createDerived(super.reverse())
    }

    override fun shuffle(): PairStream<FirstT, SecondT> {
        return createDerived(super.shuffle())
    }

    override fun toLinkedHashMap(): LinkedHashMap<FirstT, SecondT> {
        val map: KCReadOnlyMap<FirstT, SecondT> =
            map { pair -> pair.unwrapPair() }.unwrapStream().toMap()

        return LinkedHashMap(map)
    }

    override fun createDerived(
        stream: ElementStream<Pair<FirstT, SecondT>>
    ): PairStream<FirstT, SecondT> {
        return createPair(stream.unwrapStream())
    }

    override fun <ElementT> create(stream: KCStream<ElementT>): ElementStream<ElementT> {
        return DefaultElementStream(stream)
    }

    override fun <FirstT, SecondT> createPair(
        stream: KCStream<Pair<FirstT, SecondT>>
    ): PairStream<FirstT, SecondT> {
        return DefaultPairStream(stream)
    }

    override fun <ElementT> createIterable(
        stream: KCStream<ReadOnlyIterable<ElementT>>
    ): IterableStream<ElementT> {
        return DefaultIterableStream(stream)
    }
}