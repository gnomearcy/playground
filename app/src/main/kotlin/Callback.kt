interface Callback<T> {
    fun onSuccess(data: T)

    fun onError()
}
