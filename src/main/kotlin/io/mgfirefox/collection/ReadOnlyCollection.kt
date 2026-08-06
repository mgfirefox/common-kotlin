package io.mgfirefox.collection

import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.`object`.container.Container
import io.mgfirefox.`object`.convertable.StringConvertible
import io.mgfirefox.`object`.countable.Countable

interface ReadOnlyCollection<out ElementT> : ReadOnlyIterable<ElementT>, Countable,
    Container<ElementT>, StringConvertible {

    fun unwrapReadOnlyCollection(): KCReadOnlyCollection<ElementT>
}