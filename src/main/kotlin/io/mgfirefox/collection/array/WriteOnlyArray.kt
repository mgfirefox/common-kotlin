package io.mgfirefox.collection.array

import io.mgfirefox.`object`.accessor.index.WriteOnlyIndexAccessor
import io.mgfirefox.`object`.countable.Countable

interface WriteOnlyArray<in ElementT> : WriteOnlyIndexAccessor<ElementT>, Countable {

    fun unwrapWriteOnlyArray(): KWriteOnlyArray<in ElementT>
}