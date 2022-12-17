package com.yapp.domain.usecase

import com.yapp.domain.model.CalculateHistory
import com.yapp.domain.repository.HistoryRepository
import javax.inject.Inject

class InsertCalculatorHistoryUseCase @Inject constructor(
    private val historyRepository: HistoryRepository
) {
    suspend operator fun invoke(history: CalculateHistory) =
        historyRepository.insertHistory(history)
}