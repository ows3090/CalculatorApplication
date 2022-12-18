package com.yapp.data.source

import com.yapp.data.db.dao.HistoryDao
import com.yapp.data.db.entitry.CalculateHistoryEntity
import com.yapp.domain.di.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HistoryLocalDataSourceImpl @Inject constructor(
    private val historyDao: HistoryDao,
    @IODispatcher private val dispatcher: CoroutineDispatcher
): HistoryLocalDataSource {
    override fun getAll(): Flow<List<CalculateHistoryEntity>>{
        return historyDao.getAll().flowOn(dispatcher)
    }

    override suspend fun insertHistory(historyEntity: CalculateHistoryEntity) = withContext(dispatcher){
        historyDao.insertHistory(historyEntity)
    }
}