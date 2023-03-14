package com.mpfcoding.ichef_app.presentation.presentation.shoppingcar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mpfcoding.ichef_app.core.cache.datasource.LaunchCacheDataSource
import com.mpfcoding.ichef_app.core.domain.Launch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingCarViewModel @Inject constructor(
    private var launchCacheDataSource: LaunchCacheDataSource
) : ViewModel() {

    private val _orders = MutableLiveData<List<Launch>>()
    val orders: LiveData<List<Launch>> = _orders

    private val _quantityOrders = MutableLiveData<Int>()
    val quantityOrder: LiveData<Int> = _quantityOrders

    fun loadAllOrders() {
        viewModelScope.launch {
            val orders = launchCacheDataSource.getAll()
            _orders.postValue(orders)
        }
    }

    fun updateQuantity(quantity: Int, id: Int, price: Double){
        viewModelScope.launch {
            launchCacheDataSource.updateQuantity(quantity, id, price)
        }
    }
}