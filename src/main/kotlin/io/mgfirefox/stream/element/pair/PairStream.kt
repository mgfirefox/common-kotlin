package io.mgfirefox.stream.element.pair

import io.mgfirefox.data.pair.Pair
import io.mgfirefox.function.predicate.Predicate
import io.mgfirefox.stream.convert.pair.PairConvertStream
import io.mgfirefox.stream.element.ElementStream
import io.mgfirefox.stream.filter.pair.PairFilterStream
import io.mgfirefox.stream.order.pair.PairOrderStream
import io.mgfirefox.stream.transform.pair.PairTransformStream

interface PairStream<FirstT, SecondT> : ElementStream<Pair<FirstT, SecondT>>,
    PairTransformStream<FirstT, SecondT>, PairFilterStream<FirstT, SecondT>,
    PairOrderStream<FirstT, SecondT>, PairConvertStream<FirstT, SecondT> {

    override fun filter(predicate: Predicate<Pair<FirstT, SecondT>>): PairStream<FirstT, SecondT>
    override fun exclude(predicate: Predicate<Pair<FirstT, SecondT>>): PairStream<FirstT, SecondT>
    override fun distinct(): PairStream<FirstT, SecondT>

    override fun take(count: Int): PairStream<FirstT, SecondT>
    override fun takeWhile(predicate: Predicate<Pair<FirstT, SecondT>>): PairStream<FirstT, SecondT>
    override fun takeUntil(predicate: Predicate<Pair<FirstT, SecondT>>): PairStream<FirstT, SecondT>

    override fun drop(count: Int): PairStream<FirstT, SecondT>
    override fun dropWhile(predicate: Predicate<Pair<FirstT, SecondT>>): PairStream<FirstT, SecondT>
    override fun dropUntil(predicate: Predicate<Pair<FirstT, SecondT>>): PairStream<FirstT, SecondT>

    override fun reverse(): PairStream<FirstT, SecondT>

    override fun shuffle(): PairStream<FirstT, SecondT>
}