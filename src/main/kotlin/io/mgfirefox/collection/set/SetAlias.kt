package io.mgfirefox.collection.set

import kotlin.collections.LinkedHashSet
import kotlin.collections.Set

typealias KCReadOnlySet<ElementT> = Set<ElementT>
typealias KCWriteOnlySet<ElementT> = MutableSet<in ElementT>
typealias KCSet<ElementT> = MutableSet<ElementT>

typealias KCLinkedHashSet<ElementT> = LinkedHashSet<ElementT>