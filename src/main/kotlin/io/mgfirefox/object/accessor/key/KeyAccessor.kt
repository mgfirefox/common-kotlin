package io.mgfirefox.`object`.accessor.key

interface KeyAccessor<in KeyT, ElementT> : ReadOnlyKeyAccessor<KeyT, ElementT>,
    WriteOnlyKeyAccessor<KeyT, ElementT>