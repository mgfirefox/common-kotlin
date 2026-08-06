package io.mgfirefox.collection.iterator

import kotlin.collections.Iterator

typealias KCReadOnlyIterator<ElementT> = Iterator<ElementT>
typealias KCWriteOnlyIterator<ElementT> = MutableIterator<*>
typealias KCIterator<ElementT> = MutableIterator<ElementT>