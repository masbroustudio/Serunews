package com.serunews.core.source

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : com.serunews.core.source.Resource<T>(data)
    class Loading<T>(data: T? = null) : com.serunews.core.source.Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : com.serunews.core.source.Resource<T>(data, message)
}