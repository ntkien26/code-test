package com.moewsoft.newsapp.domain.common

// A generic class that contains data and status about view_loading this data.
sealed class ResultOf<T>

class Success<T>(val data: T) : ResultOf<T>()

class Loading<T>(val data: T? = null) : ResultOf<T>()

class Error<T>(val ex: Throwable) : ResultOf<T>()

inline fun <reified T> ResultOf<T>.doOnSuccess(callback: (data: T) -> Unit) {
    if (this is Success) {
        callback(this.data)
    }
}

inline fun <reified T> ResultOf<T>.doOnFailed(callback: (ex: Throwable) -> Unit) {
    if (this is Error) {
        callback(ex)
    }
}

inline fun <reified T> ResultOf<T>.doIfInProgress(callback: (data: T?) -> Unit) {
    if (this is Loading) {
        callback(data)
    }
}