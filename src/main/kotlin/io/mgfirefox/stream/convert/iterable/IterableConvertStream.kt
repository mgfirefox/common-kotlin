package io.mgfirefox.stream.convert.iterable

import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.stream.convert.ConvertStream

interface IterableConvertStream<ElementT> : ConvertStream<ReadOnlyIterable<ElementT>>