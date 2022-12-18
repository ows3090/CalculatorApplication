package com.yapp.domain.usecase

import com.yapp.domain.model.CalculateHistory
import com.yapp.domain.repository.HistoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCalculatorHistoryUseCase @Inject constructor(
    private val historyRepository: HistoryRepository
) {
    operator fun invoke(): Flow<List<CalculateHistory>> =
        historyRepository.getAll()
}