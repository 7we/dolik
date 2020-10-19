package dolik

interface AddRemoveObject<T : Any> : MutableIterable<T> {
    fun add(value: T): Boolean

    fun remove(value: T): Boolean
}

inline fun <T : Any> AddRemoveObject<T>.addAll(values: Iterable<T>): Boolean {
    return values.all(this::add)
}

inline fun <T : Any> AddRemoveObject<T>.removeAll(values: Iterable<T>): Boolean {
    return values.all(this::remove)
}