package com.mpfcoding.ichef_app.presentation.presentation.dashboard.settings

import androidx.lifecycle.ViewModel
import com.mpfcoding.ichef_app.core.cache.datasource.LaunchCacheDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val launchCacheDataSource: LaunchCacheDataSource
): ViewModel() {

    suspend fun deleteAll() {
        launchCacheDataSource.deleteAll()
    }
}