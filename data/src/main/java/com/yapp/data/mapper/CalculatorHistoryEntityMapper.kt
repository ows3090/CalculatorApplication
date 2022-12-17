package com.yapp.data.mapper

import com.yapp.data.db.entitry.CalculateHistoryEntity
import com.yapp.domain.model.CalculateHistory


fun List<CalculateHistory>.toEntity() = this.map { it.toEntity() }

fun List<CalculateHistoryEntity>.toModel() = this.map { it.toModel() }

fun CalculateHistory.toEntity() = CalculateHistoryEntity(
    operands = this.operands,
    operators = this.operators,
    result = this.result
)

fun CalculateHistoryEntity.toModel() = CalculateHistory(
    operands = this.operands,
    operators = this.operators,
    result = this.result
)