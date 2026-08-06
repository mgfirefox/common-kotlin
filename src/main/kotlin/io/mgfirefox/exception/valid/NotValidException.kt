package io.mgfirefox.exception.valid

import io.mgfirefox.exception.KRuntimeException
import io.mgfirefox.`object`.throwable.Throwable

open class NotValidException : RuntimeException {

    constructor() : this("")

    constructor(message: String) : this(message, null)

    constructor(cause: Throwable?) : this("", cause)

    constructor(message: String, cause: Throwable?) : super(message, cause)

    constructor(runtimeException: KRuntimeException) : super(runtimeException)
}