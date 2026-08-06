package io.mgfirefox.data.pair

import io.mgfirefox.`object`.convertable.StringConvertible
import io.mgfirefox.`object`.equatable.Equatable

data class Pair<out FirstT, out SecondT>(val firstValue: FirstT, val secondValue: SecondT) :
    Equatable, StringConvertible {

    constructor(pair: KPair<FirstT, SecondT>) : this(pair.first, pair.second)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other !is Pair<*, *>) {
            return false
        }

        if (firstValue != other.firstValue) {
            return false
        }
        if (secondValue != other.secondValue) {
            return false
        }

        return true
    }

    override fun hashCode(): Int {
        var result = firstValue?.hashCode() ?: 0
        result = 31 * result + (secondValue?.hashCode() ?: 0)

        return result
    }

    fun unwrapPair(): KPair<FirstT, SecondT> {
        return KPair(firstValue, secondValue)
    }

    override fun toString(): String {
        return "($firstValue, $secondValue)"
    }

    companion object
}