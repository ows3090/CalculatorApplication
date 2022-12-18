package com.yapp.data.repository

import com.yapp.data.mapper.toEntity
import com.yapp.data.mapper.toModel
import com.yapp.data.source.HistoryLocalDataSource
import com.yapp.domain.di.IODispatcher
import com.yapp.domain.model.CalculateHistory
import com.yapp.domain.repository.HistoryRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import timber.log.Timber
import javax.inject.Inject

class HistoryRepositoryImpl @Inject constructor(
    private val historyLocalDataSource: HistoryLocalDataSource,
    @IODispatcher private val dispatcher: CoroutineDispatcher // TODO: Check Validation
): HistoryRepository {
    override fun getAll(): Flow<List<CalculateHistory>> =
        historyLocalDataSource.getAll()
            .map { it.toModel() }
            .flowOn(dispatcher)
            .catch { exception ->
                emit(listOf())
                Timber.e(exception.message)
            }

    override suspend fun insertHistory(history: CalculateHistory) {
        historyLocalDataSource.insertHistory(history.toEntity())
    }
}