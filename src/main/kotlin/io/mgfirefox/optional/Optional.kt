package io.mgfirefox.optional

import io.mgfirefox.exception.optional.NoValueException

class Optional<out ValueT> private constructor(val hasValue: Boolean, value: ValueT?) {

    val value: ValueT? = value
        get() {
            if (!hasValue) {
                throw NoValueException()
            }

            return field
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