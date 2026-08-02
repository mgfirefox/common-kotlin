package io.mgfirefox.`object`.accessor.key

interface ReadOnlyKeyAccessor<in KeyT, out ElementT> {

    operator fun get(key: KeyT): ElementT
}