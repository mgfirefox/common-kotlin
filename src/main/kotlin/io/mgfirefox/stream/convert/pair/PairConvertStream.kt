package io.mgfirefox.stream.convert.pair

import io.mgfirefox.collection.map.LinkedHashMap
import io.mgfirefox.data.pair.Pair
import io.mgfirefox.stream.convert.ConvertStream

interface PairConvertStream<FirstT, SecondT> : ConvertStream<Pair<FirstT, SecondT>> {

    fun toLinkedHashMap(): LinkedHashMap<FirstT, SecondT>
}