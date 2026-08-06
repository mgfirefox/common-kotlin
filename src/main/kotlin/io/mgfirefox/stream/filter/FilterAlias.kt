package io.mgfirefox.stream.filter

typealias FilterPredicate<ElementT> = (ElementT) -> Boolean
typealias ExcludePredicate<ElementT> = (ElementT) -> Boolean