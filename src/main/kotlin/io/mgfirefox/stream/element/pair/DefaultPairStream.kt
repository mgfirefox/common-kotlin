package io.mgfirefox.stream.element.pair

import io.mgfirefox.collection.array.KReadOnlyArray
import io.mgfirefox.collection.map.KCReadOnlyMap
import io.mgfirefox.collection.map.LinkedHashMap
import io.mgfirefox.data.pair.Pair
import io.mgfirefox.stream.KCStream
import io.mgfirefox.stream.Stream
import io.mgfirefox.stream.convert.pair.PairConvertStream
import io.mgfirefox.stream.element.DefaultElementStream
import io.mgfirefox.stream.filter.ExcludePredicate
import io.mgfirefox.stream.filter.FilterPredicate

class DefaultPairStream<FirstT, SecondT>(stream: KCStream<Pair<FirstT, SecondT>>) :
    DefaultElementStream<Pair<FirstT, SecondT>>(stream), PairStream<FirstT, SecondT>,
    PairConvertStream<FirstT, SecondT> {

    override fun filter(
        predicate: FilterPredicate<Pair<FirstT, SecondT>>
    ): PairStream<FirstT, SecondT> {
        return from(super.filter(predicate))
    }

    override fun exclude(
        predicate: ExcludePredicate<Pair<FirstT, SecondT>>
    ): PairStream<FirstT, SecondT> {
        return from(super.exclude(predicate))
    }

    override fun reverse(): PairStream<FirstT, SecondT> {
        return from(super.reverse())
    }

    override fun shuffle(): PairStream<FirstT, SecondT> {
        return from(super.shuffle())
    }

    override fun toLinkedHashMap(): LinkedHashMap<FirstT, SecondT> {
        val map: KCReadOnlyMap<FirstT, SecondT> =
            map { pair -> pair.unwrapPair() }.unwrapStream().toMap()

        return LinkedHashMap(map)
    }

    companion object {

        @JvmStatic
        fun <KeyT, ValueT> from(
            stream: Stream<Pair<KeyT, ValueT>>
        ): DefaultPairStream<KeyT, ValueT> {
            return DefaultPairStream(stream.unwrapStream())
        }
    }
}