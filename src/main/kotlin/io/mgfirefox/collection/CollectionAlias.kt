package io.mgfirefox.collection

import kotlin.collections.Collection

typealias KCReadOnlyCollection<ElementT> = Collection<ElementT>
typealias KCWriteOnlyCollection<ElementT> = MutableCollection<in ElementT>
typealias KCCollection<ElementT> = MutableCollection<ElementT>