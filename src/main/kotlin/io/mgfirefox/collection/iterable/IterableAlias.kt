package io.mgfirefox.collection.iterable

import kotlin.collections.Iterable

typealias KCReadOnlyIterable<ElementT> = Iterable<ElementT>
typealias KCWriteOnlyIterable<ElementT> = MutableIterable<*>
typealias KCIterable<ElementT> = MutableIterable<ElementT>