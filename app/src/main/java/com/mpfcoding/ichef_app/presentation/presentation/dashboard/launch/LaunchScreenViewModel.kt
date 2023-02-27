package com.mpfcoding.ichef_app.presentation.presentation.dashboard.launch

import androidx.lifecycle.ViewModel
import com.mpfcoding.ichef_app.core.cache.datasource.LaunchCacheDataSource
import com.mpfcoding.ichef_app.core.domain.Launch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LaunchScreenViewModel @Inject constructor(
    private val launchCacheDataSource: LaunchCacheDataSource
): ViewModel() {

    suspend fun insertLaunch(launch: Launch) {
        launchCacheDataSource.insert(launch)
    }
}