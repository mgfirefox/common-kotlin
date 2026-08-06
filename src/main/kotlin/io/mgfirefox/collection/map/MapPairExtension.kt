@file:JvmName("MapPairUtility")

package io.mgfirefox.collection.map

import io.mgfirefox.data.pair.Pair

fun <KeyT, ValueT> Pair.Companion.fromMapEntry(
    mapEntry: KCMapEntry<KeyT, ValueT>
): Pair<KeyT, ValueT> {
    return Pair(mapEntry.key, mapEntry.value)
}