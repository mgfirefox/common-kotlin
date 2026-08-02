package io.mgfirefox.`object`.equatable

interface Equatable {

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
}