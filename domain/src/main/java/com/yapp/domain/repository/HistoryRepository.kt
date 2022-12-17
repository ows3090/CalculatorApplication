package com.yapp.domain.repository

import com.yapp.domain.model.CalculateHistory
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {
    suspend fun getAll(): Flow<List<CalculateHistory>>
    suspend fun insertHistory(history: CalculateHistory)
}