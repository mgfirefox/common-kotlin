package io.mgfirefox.`object`.comparable

interface Comparable<in OtherT> : KComparable<OtherT> {

    override fun compareTo(other: OtherT): Int
}