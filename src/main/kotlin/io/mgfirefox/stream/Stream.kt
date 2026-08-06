package io.mgfirefox.stream

interface Stream<out ElementT> {

    fun unwrapStream(): KCStream<ElementT>
}