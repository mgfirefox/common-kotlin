package io.mgfirefox.exception

import io.mgfirefox.`object`.throwable.Throwable

open class Exception : Throwable {

    constructor() : this("")

    constructor(message: String) : this(message, null)

    constructor(cause: Throwable?) : this("", cause)

    constructor(message: String, cause: Throwable?) : super(message, cause)

    constructor(exception: KException) : super(exception)

    fun unwrapException(): KException {
        return KException(message, cause)
    }
}