package io.mgfirefox.stream.filter.pair

import io.mgfirefox.data.pair.Pair
import io.mgfirefox.stream.filter.ExcludePredicate
import io.mgfirefox.stream.filter.FilterPredicate
import io.mgfirefox.stream.filter.FilterStream

interface PairFilterStream<FirstT, SecondT> : FilterStream<Pair<FirstT, SecondT>> {

    override fun filter(
        predicate: FilterPredicate<Pair<FirstT, SecondT>>
    ): PairFilterStream<FirstT, SecondT>

    override fun exclude(
        predicate: ExcludePredicate<Pair<FirstT, SecondT>>
    ): PairFilterStream<FirstT, SecondT>
}