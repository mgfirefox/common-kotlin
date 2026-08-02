package io.mgfirefox.`object`.throwable

open class Throwable(message: String, cause: Throwable?) : KThrowable(message, cause) {

    constructor() : this("")

    constructor(message: String) : this(message, null)

    constructor(cause: Throwable?) : this("", cause)

    constructor(throwable: KThrowable) : this(throwable.message ?: "",
        throwable.cause?.let { Throwable(it) })
}