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
    private val operands = mutableListOf<String>()
    private val operators = mutableListOf<String>()
    private var currentNum: String = ""

    private val _sentenceState = MutableStateFlow("")
    val setenceState = _sentenceState.asStateFlow()

    private val _resultState = MutableStateFlow<MainResultState>(MainResultState.None)
    val resultState = _resultState.asStateFlow()

    val historyState: StateFlow<List<MainViewState>> =
        getAllCalculatorHistoryUseCase()
            .distinctUntilChanged()
            .map { list ->
                list.map { MainViewState(it.operands, it.operators, it.result) }
            }
            .debounce(50)
            .stateIn(viewModelScope, SharingStarted.Eagerly, listOf())


    fun clickCalculator(isOperator: Boolean, value: String) {
        if (isOperator) {
            operands.add(currentNum)
            operators.add(value)
            currentNum = ""
            _sentenceState.value += " $value "
        } else {
            currentNum += value
            _sentenceState.value += value
        }
    }

    fun clickResult() {
        operands.add(currentNum)
        operators.add(0, "+")
        currentNum = ""

        if (operands.size == operators.size) {
            val result = operands.foldIndexed(0) { index, acc, s ->
                when (operators[index]) {
                    "+" -> acc + s.toInt()
                    "-" -> acc - s.toInt()
                    else -> acc * s.toInt()
                }
            }
            _resultState.value = MainResultState.Success(
                MainViewState(
                    operands,
                    operators,
                    result.toString()
                )
            )

            viewModelScope.launch {
                insertCalculateHistoryUseCase(
                    CalculateHistory(
                        operands,
                        operators,
                        result.toString()
                    )
                )
            }
        } else {
            _resultState.value = MainResultState.Error("계산 안됨")
        }

    }

    fun clickCancel() {
        operands.clear()
        operators.clear()
        currentNum = ""
        _resultState.value = MainResultState.None
        _sentenceState.value = ""
    }

}