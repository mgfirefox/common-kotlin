package io.mgfirefox.stream.filter.pair

import io.mgfirefox.data.pair.Pair
import io.mgfirefox.function.predicate.Predicate
import io.mgfirefox.stream.filter.FilterStream

interface PairFilterStream<FirstT, SecondT> : FilterStream<Pair<FirstT, SecondT>> {

    override fun filter(
        predicate: Predicate<Pair<FirstT, SecondT>>
    ): PairFilterStream<FirstT, SecondT>

    override fun exclude(
        predicate: Predicate<Pair<FirstT, SecondT>>
    ): PairFilterStream<FirstT, SecondT>
}