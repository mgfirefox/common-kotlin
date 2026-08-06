package io.mgfirefox.stream.transform.pair

import io.mgfirefox.data.pair.Pair
import io.mgfirefox.stream.transform.TransformStream

interface PairTransformStream<FirstT, SecondT> : TransformStream<Pair<FirstT, SecondT>>