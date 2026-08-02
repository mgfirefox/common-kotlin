package io.mgfirefox.`object`.comparable

interface Comparable<in OtherT> {

    operator fun compareTo(other: OtherT): Int
}