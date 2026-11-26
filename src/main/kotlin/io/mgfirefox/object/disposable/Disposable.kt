package io.mgfirefox.`object`.disposable

interface Disposable : AutoCloseable {
    val isDisposed: Boolean

    fun dispose()

    override fun close() {
        dispose()
    }
}