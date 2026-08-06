package io.mgfirefox.collection.map

import io.mgfirefox.collection.WriteOnlyCollection
import io.mgfirefox.data.pair.Pair
import io.mgfirefox.`object`.accessor.key.WriteOnlyKeyAccessor

interface WriteOnlyMap<in KeyT, in ValueT> : WriteOnlyCollection<Pair<KeyT, ValueT>>,
    WriteOnlyKeyAccessor<KeyT, ValueT> {

    override fun set(key: KeyT, @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE") value: ValueT)

    fun discardBy(key: KeyT): Boolean

    fun unwrapWriteOnlyMap(): KCWriteOnlyMap<KeyT, ValueT>
}