package com.piotrapps.aurainterview.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piotrapps.domain.usecase.GetBootItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getBootItemsUseCase: GetBootItemsUseCase
) : ViewModel() {

    private val _bootTimes = MutableStateFlow<BootUiState?>(null)
    val bootTimes = _bootTimes.asStateFlow()

    init {
        viewModelScope.launch {
            //TODO: use case for obtaining allowed dismissal count and interval from database

            getBootItemsUseCase().collectLatest { list ->
                val dateFormat = SimpleDateFormat(DATE_PATTERN, Locale.getDefault())

                val bootDateMap = list.map {
                    dateFormat.format(it.bootDate)
                }.groupBy {
                    it
                }

                _bootTimes.update {
                    BootUiState(bootDateMap.map { (key, value) -> "$key - ${value.size}" })
                }
            }
        }
    }

    companion object {
        private const val DATE_PATTERN = "dd/MM/yyyy"
    }
}