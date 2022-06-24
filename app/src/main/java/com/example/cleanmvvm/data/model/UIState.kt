package com.example.cleanmvvm.data.model

sealed class UIState
data class Success(val data: Any) : UIState()
data class Failed(val error: String) : UIState()
