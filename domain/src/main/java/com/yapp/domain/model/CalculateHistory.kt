package com.yapp.domain.model

data class CalculateHistory(
    val operands: List<String> = listOf(),
    val operators: List<String> = listOf(),
    val result: String = ""
)
