package io.mgfirefox.`object`.accessor.key

interface WriteOnlyKeyAccessor<in KeyT, in ElementT> {

    operator fun set(key: KeyT, element: ElementT)
}