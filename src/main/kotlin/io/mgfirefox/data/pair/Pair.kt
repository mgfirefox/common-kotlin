package io.mgfirefox.data.pair

import io.mgfirefox.`object`.convertable.StringConvertible
import io.mgfirefox.`object`.equatable.Equatable

data class Pair<out FirstT, out SecondT>(val first: FirstT, val second: SecondT) :
    Equatable, StringConvertible {

    constructor(pair: KPair<FirstT, SecondT>) : this(pair.first, pair.second)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other !is Pair<*, *>) {
            return false
        }

        if (first != other.first) {
            return false
        }
        if (second != other.second) {
            return false
        }

        return true
    }

    override fun hashCode(): Int {
        var result = first?.hashCode() ?: 0
        result = 31 * result + (second?.hashCode() ?: 0)

        return result
    }

    fun unwrapPair(): KPair<FirstT, SecondT> {
        return KPair(first, second)
    }

    override fun toString(): String {
        return "($first, $second)"
    }

    companion object
}