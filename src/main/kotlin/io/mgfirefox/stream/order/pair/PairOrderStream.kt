package io.mgfirefox.stream.order.pair

import io.mgfirefox.data.pair.Pair
import io.mgfirefox.stream.order.OrderStream

interface PairOrderStream<out FirstT, out SecondT> : OrderStream<Pair<FirstT, SecondT>> {

    override fun reverse(): PairOrderStream<FirstT, SecondT>

    override fun shuffle(): PairOrderStream<FirstT, SecondT>
}