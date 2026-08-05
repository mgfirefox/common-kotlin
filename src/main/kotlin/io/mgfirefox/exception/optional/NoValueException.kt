package io.mgfirefox.exception.optional

private const val NO_VALUE_MESSAGE: String = "No value has been retrieved"

class NoValueException private constructor(message: String) : RuntimeException(message) {

    constructor() : this(NO_VALUE_MESSAGE)

    constructor(noValueException: KNoValueException) : this(
        noValueException.message ?: NO_VALUE_MESSAGE)

    fun unwrapNoValueException(): KNoValueException {
        return KNoValueException(message)
    }
}