package io.mgfirefox.collection.list

import kotlin.collections.ArrayList
import kotlin.collections.List

typealias KCReadOnlyList<ElementT> = List<ElementT>
typealias KCWriteOnlyList<ElementT> = MutableList<in ElementT>
typealias KCList<ElementT> = MutableList<ElementT>

typealias KCArrayList<ElementT> = ArrayList<ElementT>