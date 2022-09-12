package com.lilyhill.haliene

sealed class MainEvent {
    class Success(val jsonObject: Any) : MainEvent()
    class Failure(val m: String) : MainEvent()
    object Empty : MainEvent()
    object Loading : MainEvent()
}