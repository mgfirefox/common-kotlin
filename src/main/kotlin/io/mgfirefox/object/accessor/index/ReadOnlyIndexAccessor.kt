package io.mgfirefox.`object`.accessor.index

import io.mgfirefox.`object`.accessor.key.ReadOnlyKeyAccessor

interface ReadOnlyIndexAccessor<out ElementT> : ReadOnlyKeyAccessor<Int, ElementT> {

    override fun get(@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE") index: Int): ElementT
}