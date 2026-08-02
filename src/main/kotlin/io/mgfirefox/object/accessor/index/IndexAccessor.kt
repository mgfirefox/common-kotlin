package io.mgfirefox.`object`.accessor.index

import io.mgfirefox.`object`.accessor.key.KeyAccessor

interface IndexAccessor<ElementT> : KeyAccessor<Int, ElementT>, ReadOnlyIndexAccessor<ElementT>,
    WriteOnlyIndexAccessor<ElementT> {

    override fun get(@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE") index: Int): ElementT
    override fun set(@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE") index: Int, element: ElementT)
}