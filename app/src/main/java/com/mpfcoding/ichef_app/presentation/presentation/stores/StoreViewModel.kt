package com.mpfcoding.ichef_app.presentation.presentation.stores

import androidx.compose.runtime.mutableStateListOf
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

    var storeList = mutableStateListOf<Store>()

    fun fetchStores(){
        viewModelScope.launch {
            val itens = userRepository.getStore()
            storeList.clear()
            storeList.addAll(itens)
        }
    }
}