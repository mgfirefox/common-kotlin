package io.mgfirefox.exception.optional

import io.mgfirefox.exception.runtime.RuntimeException

class NoValueException : RuntimeException {

    constructor() : super("No value has been retrieved")

    constructor(noSuchElementException: NoSuchElementException) : super(noSuchElementException)

    fun unwrapNoValueException(): NoSuchElementException {
        return NoSuchElementException(message)
    }
}