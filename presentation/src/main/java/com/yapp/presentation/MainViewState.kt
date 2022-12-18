package com.yapp.presentation

data class MainViewState(
    val operands: List<String> = listOf(),
    val operators: List<String> = listOf(),
    val result: String = ""
)