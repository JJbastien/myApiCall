package com.example.myapicall.utils

import android.app.UiAutomation
import com.example.myapicall.model.JokeResponse
import com.example.myapicall.model.Jokes

sealed class UIState {
    object LOADING: UIState()
    data class SUCCESS<T>(val response: T ): UIState()
    data class ERROR(val error: Exception): UIState()

}

enum class STATE {
    LOADING,
    ERROR,
    SUCCESS
}