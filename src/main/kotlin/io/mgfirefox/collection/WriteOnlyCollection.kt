package io.mgfirefox.collection

import io.mgfirefox.collection.iterable.WriteOnlyIterable
import io.mgfirefox.`object`.convertable.StringConvertible
import io.mgfirefox.`object`.countable.Countable

interface WriteOnlyCollection<in ElementT> : WriteOnlyIterable<ElementT>, Countable,
    StringConvertible {

    fun add(element: ElementT)
    fun remove(element: ElementT): Boolean
    fun clear()

    fun unwrapWriteOnlyCollection(): KCWriteOnlyCollection<ElementT>
}