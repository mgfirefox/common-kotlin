package io.mgfirefox.stream.order

import io.mgfirefox.stream.Stream

interface OrderStream<out ElementT> : Stream<ElementT> {

    fun reverse(): OrderStream<ElementT>

    fun shuffle(): OrderStream<ElementT>
}