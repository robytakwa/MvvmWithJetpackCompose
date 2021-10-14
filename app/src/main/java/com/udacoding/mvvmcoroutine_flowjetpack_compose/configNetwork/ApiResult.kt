package com.udacoding.mvvmcoroutine_flowjetpack_compose.configNetwork

open class ApiResult<out R> {
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Error(val throwable: Throwable) : ApiResult<Nothing>()
}