package com.mpfcoding.ichef_app.presentation.presentation.dashboard

import androidx.lifecycle.ViewModel
import com.mpfcoding.ichef_app.core.cache.datasource.LaunchCacheDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val launchCacheDataSource: LaunchCacheDataSource
) : ViewModel() {

    suspend fun sumProducts(): Int {
        return launchCacheDataSource.sumQuantityLaunchs()
    }
}