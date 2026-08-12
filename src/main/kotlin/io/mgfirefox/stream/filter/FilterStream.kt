package io.mgfirefox.stream.filter

import io.mgfirefox.function.predicate.Predicate
import io.mgfirefox.stream.Stream

interface FilterStream<out ElementT> : Stream<ElementT> {

    fun filter(predicate: Predicate<ElementT>): FilterStream<ElementT>
    fun exclude(predicate: Predicate<ElementT>): FilterStream<ElementT>
    fun distinct(): FilterStream<ElementT>
    
    fun take(count: Int): FilterStream<ElementT>
    fun takeWhile(predicate: Predicate<ElementT>): FilterStream<ElementT>
    fun takeUntil(predicate: Predicate<ElementT>): FilterStream<ElementT>
    
    fun drop(count: Int): FilterStream<ElementT>
    fun dropWhile(predicate: Predicate<ElementT>): FilterStream<ElementT>
    fun dropUntil(predicate: Predicate<ElementT>): FilterStream<ElementT>
}