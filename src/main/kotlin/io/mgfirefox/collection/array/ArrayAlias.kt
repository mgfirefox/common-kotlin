package io.mgfirefox.collection.array

import kotlin.Array

typealias KReadOnlyArray<ElementT> = Array<out ElementT>
typealias KWriteOnlyArray<ElementT> = Array<in ElementT>
typealias KArray<ElementT> = Array<ElementT>

typealias KTypedArray<ElementT> = Array<ElementT>

typealias ArrayInitializer<ElementT> = (Int) -> ElementT