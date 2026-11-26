package io.mgfirefox.exception.optional

private const val EMPTY_VALUE_MESSAGE: String = "Empty value has been retrieved"

class EmptyValueException private constructor(message: String) : RuntimeException(message) {

    constructor() : this(EMPTY_VALUE_MESSAGE)

    constructor(emptyValueException: KEmptyValueException) : this(
        emptyValueException.message ?: EMPTY_VALUE_MESSAGE)

    fun unwrapEmptyValueException(): KEmptyValueException {
        return KEmptyValueException(message)
    }
}