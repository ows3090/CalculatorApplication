package com.yapp.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yapp.domain.model.CalculateHistory
import com.yapp.domain.usecase.GetAllCalculatorHistoryUseCase
import com.yapp.domain.usecase.InsertCalculatorHistoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllCalculatorHistoryUseCase: GetAllCalculatorHistoryUseCase,
    private val insertCalculateHistoryUseCase: InsertCalculatorHistoryUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _mainViewState = MutableStateFlow(MainViewState())
    val mainViewState = _mainViewState.asStateFlow()

    val historyState: StateFlow<List<CalculateHistory>> =
        getAllCalculatorHistoryUseCase()
            .distinctUntilChanged()
            .debounce(50)
            .stateIn(viewModelScope, SharingStarted.Eagerly, listOf())


    fun clickCalculator(isOperator: Boolean, value: String) {
        _mainViewState.value = MainViewState(
            operands = _mainViewState.value.operands + if (isOperator) listOf() else listOf(value),
            operators = _mainViewState.value.operators + if (isOperator) listOf(value) else listOf(),
            result = _mainViewState.value.result
        )
    }

    fun clickResult(){

    }
}