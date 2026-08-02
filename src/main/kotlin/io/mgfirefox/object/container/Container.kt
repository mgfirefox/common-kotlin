package io.mgfirefox.`object`.container

interface Container<out ElementT> {

    operator fun contains(element: @UnsafeVariance ElementT): Boolean
}