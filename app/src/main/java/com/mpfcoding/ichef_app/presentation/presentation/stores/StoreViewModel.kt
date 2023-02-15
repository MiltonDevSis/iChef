package com.mpfcoding.ichef_app.presentation.presentation.stores

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mpfcoding.ichef_app.core.data.repository.UserRepository
import com.mpfcoding.ichef_app.core.domain.Store
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoreViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _stores = MutableStateFlow<List<Store>>(emptyList())
    var stores = _stores.asStateFlow()

    fun fetchStores(){
        viewModelScope.launch {
            _stores.value = userRepository.getStore()
        }
    }
}