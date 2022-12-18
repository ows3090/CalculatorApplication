package com.yapp.data.db.entitry

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CalculateHistoryEntity(
    val operands: List<String> = listOf(),
    val operators: List<String> = listOf(),
    val result: String = ""
){
    @PrimaryKey
    var historyId: Long = 0L
}
