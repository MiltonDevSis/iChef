package com.mpfcoding.ichef_app.presentation.presentation.shoppingcar

import androidx.lifecycle.ViewModel
import com.mpfcoding.ichef_app.core.cache.datasource.LaunchCacheDataSource
import com.mpfcoding.ichef_app.core.domain.Launch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShoppingCarViewModel @Inject constructor(
    private var launchCacheDataSource: LaunchCacheDataSource
): ViewModel() {

    suspend fun getAllOrders(): List<Launch>{
       return launchCacheDataSource.getAll()
    }
}