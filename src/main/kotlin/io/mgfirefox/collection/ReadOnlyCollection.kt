package io.mgfirefox.collection

import io.mgfirefox.collection.iterable.ReadOnlyIterable
import io.mgfirefox.`object`.container.Container
import io.mgfirefox.`object`.convertible.StringConvertible
import io.mgfirefox.`object`.countable.Countable
import io.mgfirefox.`object`.equatable.Equatable

interface ReadOnlyCollection<out ElementT> : ReadOnlyIterable<ElementT>, Countable,
    Container<ElementT>, Equatable, StringConvertible {

    fun unwrapReadOnlyCollection(): KCReadOnlyCollection<ElementT>
}