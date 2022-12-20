package com.yapp.presentation

data class MainViewState(
    val operands: List<String>,
    val operators: List<String>,
    val result: String
)