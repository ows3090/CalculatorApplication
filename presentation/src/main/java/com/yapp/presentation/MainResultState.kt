package com.yapp.presentation

sealed class MainResultState {
    object None : MainResultState()
    data class Success(
        val mainViewState: MainViewState
    ) : MainResultState()

    data class Error(val error: String) : MainResultState()
}
