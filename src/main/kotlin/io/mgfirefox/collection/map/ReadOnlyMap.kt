package io.mgfirefox.collection.map

import io.mgfirefox.collection.ReadOnlyCollection
import io.mgfirefox.collection.set.ReadOnlySet
import io.mgfirefox.data.pair.Pair
import io.mgfirefox.`object`.accessor.key.ReadOnlyKeyAccessor

interface ReadOnlyMap<KeyT, out ValueT> : ReadOnlyCollection<Pair<KeyT, ValueT>>,
    ReadOnlyKeyAccessor<KeyT, ValueT> {

    val keys: ReadOnlySet<KeyT>
    val values: ReadOnlyCollection<ValueT>

    fun containsKey(key: KeyT): Boolean
    fun containsValue(value: @UnsafeVariance ValueT): Boolean

    fun unwrapReadOnlyMap(): KCReadOnlyMap<KeyT, ValueT>
}