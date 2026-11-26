package io.mgfirefox.exception

import io.mgfirefox.`object`.throwable.Throwable

open class Error : Throwable {

    constructor() : this("")

    constructor(message: String) : this(message, null)

    constructor(cause: Throwable?) : this("", cause)

    constructor(message: String, cause: Throwable?) : super(message, cause)

    constructor(error: KError) : super(error)

    fun unwrapError(): KError {
        return KError(message, cause)
    }
}