package io.mgfirefox.stream.order.iterable

import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.stream.order.OrderStream

interface IterableOrderStream<out ElementT> : OrderStream<ReadOnlyIterable<ElementT>> {

    override fun reverse(): IterableOrderStream<ElementT>

    override fun shuffle(): IterableOrderStream<ElementT>
}