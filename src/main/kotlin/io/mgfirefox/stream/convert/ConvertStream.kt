package io.mgfirefox.stream.convert

import io.mgfirefox.collection.array.TypedArray
import io.mgfirefox.collection.list.ArrayList
import io.mgfirefox.collection.set.LinkedHashSet
import io.mgfirefox.stream.Stream

interface ConvertStream<ElementT> : Stream<ElementT> {

    fun toTypedArray(): TypedArray<ElementT>
    fun toArrayList(): ArrayList<ElementT>
    fun toLinkedHashSet(): LinkedHashSet<ElementT>
}