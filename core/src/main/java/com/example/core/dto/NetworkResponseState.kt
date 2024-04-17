package com.example.core.dto

sealed class NetworkResponseState<out T : Any>{
    object Loading : NetworkResponseState<Nothing>()
    data class Success<out T : Any>(val result : T?) : NetworkResponseState<T>()
    data class Error(val exception : String) : NetworkResponseState<Nothing>()
}
