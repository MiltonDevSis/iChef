package com.mpfcoding.ichef_app.presentation.presentation.intro

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    var isLoading = _isLoading.asStateFlow()

    init {
        viewModelScope.launch {
            delay(TIME_DELAY)
            _isLoading.value = false
        }
    }

    companion object{
        const val TIME_DELAY = 2000L
    }
}