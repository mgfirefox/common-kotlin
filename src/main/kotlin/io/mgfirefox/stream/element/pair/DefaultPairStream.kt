package io.mgfirefox.stream.element.pair

import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.collection.map.KCReadOnlyMap
import io.mgfirefox.collection.map.LinkedHashMap
import io.mgfirefox.data.pair.Pair
import io.mgfirefox.stream.KCStream
import io.mgfirefox.stream.convert.pair.PairConvertStream
import io.mgfirefox.stream.element.AbstractElementStream
import io.mgfirefox.stream.element.DefaultElementStream
import io.mgfirefox.stream.element.ElementStream
import io.mgfirefox.stream.element.iterable.DefaultIterableStream
import io.mgfirefox.stream.element.iterable.IterableStream
import io.mgfirefox.stream.filter.ExcludePredicate
import io.mgfirefox.stream.filter.FilterPredicate

class DefaultPairStream<FirstT, SecondT>(stream: KCStream<Pair<FirstT, SecondT>>) :
    AbstractElementStream<Pair<FirstT, SecondT>>(stream), PairStream<FirstT, SecondT>,
    PairConvertStream<FirstT, SecondT> {

    override fun filter(
        predicate: FilterPredicate<Pair<FirstT, SecondT>>
    ): PairStream<FirstT, SecondT> {
        return createDerived(super.filter(predicate))
    }

    override fun exclude(
        predicate: ExcludePredicate<Pair<FirstT, SecondT>>
    ): PairStream<FirstT, SecondT> {
        return createDerived(super.exclude(predicate))
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