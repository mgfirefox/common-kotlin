package io.mgfirefox.stream.filter.pair

import io.mgfirefox.data.pair.Pair
import io.mgfirefox.function.predicate.Predicate
import io.mgfirefox.stream.filter.FilterStream

interface PairFilterStream<out FirstT, out SecondT> : FilterStream<Pair<FirstT, SecondT>> {

    override fun filter(
        predicate: Predicate<Pair<FirstT, SecondT>>
    ): PairFilterStream<FirstT, SecondT>

    override fun exclude(
        predicate: Predicate<Pair<FirstT, SecondT>>
    ): PairFilterStream<FirstT, SecondT>
    override fun distinct(): PairFilterStream<FirstT, SecondT>
    
    override fun take(count: Int): PairFilterStream<FirstT, SecondT>
    override fun takeWhile(predicate: Predicate<Pair<FirstT, SecondT>>): PairFilterStream<FirstT, SecondT>
    override fun takeUntil(predicate: Predicate<Pair<FirstT, SecondT>>): PairFilterStream<FirstT, SecondT>

    override fun drop(count: Int): PairFilterStream<FirstT, SecondT>
    override fun dropWhile(predicate: Predicate<Pair<FirstT, SecondT>>): PairFilterStream<FirstT, SecondT>
    override fun dropUntil(predicate: Predicate<Pair<FirstT, SecondT>>): PairFilterStream<FirstT, SecondT>
}