package io.mgfirefox.collection.set

import io.mgfirefox.collection.ReadOnlyCollection

interface ReadOnlySet<out ElementT> : ReadOnlyCollection<ElementT> {

    fun unwrapReadOnlySet(): KCReadOnlySet<ElementT>
}