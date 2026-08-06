package io.mgfirefox.exception.valid.key

import io.mgfirefox.collection.set.ReadOnlySet
import io.mgfirefox.exception.valid.NotValidException

class KeyNotValidException(val key: Any?, val validKeys: ReadOnlySet<Any?>) :
    NotValidException("Key $key is not valid. Valid keys are $validKeys") {

    fun unwrapKeyNotValidException(): KKeyNotValidException {
        return KKeyNotValidException(message)
    }
}