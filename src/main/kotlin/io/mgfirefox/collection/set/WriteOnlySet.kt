package io.mgfirefox.collection.set

import io.mgfirefox.collection.WriteOnlyCollection

interface WriteOnlySet<in ElementT> : WriteOnlyCollection<ElementT> {

    fun insert(element: ElementT): Boolean

    fun unwrapWriteOnlySet(): KCWriteOnlySet<in ElementT>
}