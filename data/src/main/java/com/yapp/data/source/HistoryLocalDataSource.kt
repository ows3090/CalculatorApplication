package com.yapp.data.source

import com.yapp.data.db.entitry.CalculateHistoryEntity
import kotlinx.coroutines.flow.Flow

interface HistoryLocalDataSource {
    suspend fun getAll(): Flow<List<CalculateHistoryEntity>>
    suspend fun insertHistory(historyEntity: CalculateHistoryEntity)
}