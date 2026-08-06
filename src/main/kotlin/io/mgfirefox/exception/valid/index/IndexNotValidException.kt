package io.mgfirefox.exception.valid.index

import io.mgfirefox.exception.valid.NotValidException

class IndexNotValidException(
    val index: Int, val minValidIndex: Int, val maxValidIndexExclusive: Int
) : NotValidException(
    "Index $index is not valid. Valid index range is [$minValidIndex, $maxValidIndexExclusive)") {

    constructor(index: Int, maxValidIndexExclusive: Int) : this(index, 0, maxValidIndexExclusive)

    fun unwrapIndexNotValidException(): KIndexNotValidException {
        return KIndexNotValidException(message)
    }
}