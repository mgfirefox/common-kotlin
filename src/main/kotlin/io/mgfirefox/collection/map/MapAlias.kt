package io.mgfirefox.collection.map

import kotlin.collections.LinkedHashMap
import kotlin.collections.Map

typealias KCReadOnlyMap<KeyT, ValueT> = Map<KeyT, ValueT>
typealias KCWriteOnlyMap<KeyT, ValueT> = MutableMap<in KeyT, in ValueT>
typealias KCMap<KeyT, ValueT> = MutableMap<KeyT, ValueT>

typealias KCMapEntry<KeyT, ValueT> = Map.Entry<KeyT, ValueT>

typealias KCLinkedHashMap<KeyT, ValueT> = LinkedHashMap<KeyT, ValueT>