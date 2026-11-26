package io.mgfirefox.exception

import io.mgfirefox.`object`.throwable.Throwable

open class RuntimeException : Throwable {

    constructor() : this("")

    constructor(message: String) : this(message, null)

    constructor(cause: Throwable?) : this("", cause)

    constructor(message: String, cause: Throwable?) : super(message, cause)

    constructor(runtimeException: KRuntimeException) : super(runtimeException)

    fun unwrapRuntimeException(): KRuntimeException {
        return KRuntimeException(message, cause)
    }
}