package io.mgfirefox.optional

import io.mgfirefox.exception.optional.NoValueException

class Optional<out ValueT> private constructor(val hasValue: Boolean, private val _value: ValueT?) {

    val value: ValueT
        get() {
            if (!hasValue) {
                throw NoValueException()
            }

            return _value!!
        }

    private constructor() : this(false, null)

    private constructor(value: ValueT) : this(true, value)

    companion object {

        @JvmStatic
        fun <ValueT> of(value: ValueT): Optional<ValueT> {
            return Optional(value)
        }

        @JvmStatic
        fun <ValueT> ofEmpty(): Optional<ValueT> {
            return Optional()
        }
    }
}