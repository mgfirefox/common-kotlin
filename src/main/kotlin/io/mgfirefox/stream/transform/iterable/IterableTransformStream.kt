package io.mgfirefox.stream.transform.iterable

import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.stream.transform.TransformStream

interface IterableTransformStream<out ElementT> : TransformStream<ReadOnlyIterable<ElementT>> {

    fun flatten(): TransformStream<ElementT>
}