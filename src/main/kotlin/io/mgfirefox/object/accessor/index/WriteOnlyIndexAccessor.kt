package io.mgfirefox.`object`.accessor.index

import io.mgfirefox.`object`.accessor.key.WriteOnlyKeyAccessor

interface WriteOnlyIndexAccessor<in ElementT> : WriteOnlyKeyAccessor<Int, ElementT> {

    override fun set(@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE") index: Int, element: ElementT)
}