package io.mgfirefox.collection.map

import io.mgfirefox.collection.Collection
import io.mgfirefox.data.pair.Pair
import io.mgfirefox.`object`.accessor.key.KeyAccessor
import io.mgfirefox.optional.Optional

interface Map<KeyT, ValueT> : Collection<Pair<KeyT, ValueT>>, KeyAccessor<KeyT, ValueT>,
    ReadOnlyMap<KeyT, ValueT>, WriteOnlyMap<KeyT, ValueT> {

    override fun set(key: KeyT, @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE") value: ValueT)

    fun removeBy(key: KeyT): Optional<ValueT>

    fun unwrapMap(): KCMap<KeyT, ValueT>
}