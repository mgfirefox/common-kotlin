package io.mgfirefox.stream.element.pair

import io.mgfirefox.collection.map.LinkedHashMap
import io.mgfirefox.data.pair.Pair
import io.mgfirefox.stream.element.ElementStream
import io.mgfirefox.stream.filter.ExcludePredicate
import io.mgfirefox.stream.filter.FilterPredicate
import io.mgfirefox.stream.filter.pair.PairFilterStream
import io.mgfirefox.stream.order.pair.PairOrderStream
import io.mgfirefox.stream.transform.pair.PairTransformStream

interface PairStream<FirstT, SecondT> : ElementStream<Pair<FirstT, SecondT>>,
    PairTransformStream<FirstT, SecondT>, PairFilterStream<FirstT, SecondT>,
    PairOrderStream<FirstT, SecondT> {

    override fun filter(
        predicate: FilterPredicate<Pair<FirstT, SecondT>>
    ): PairStream<FirstT, SecondT>

    override fun exclude(
        predicate: ExcludePredicate<Pair<FirstT, SecondT>>
    ): PairStream<FirstT, SecondT>

    override fun reverse(): PairStream<FirstT, SecondT>

    override fun shuffle(): PairStream<FirstT, SecondT>

    fun toLinkedHashMap(): LinkedHashMap<FirstT, SecondT>
}