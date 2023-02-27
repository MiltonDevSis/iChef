package com.mpfcoding.ichef_app.framework.di

import android.content.Context
import com.mpfcoding.ichef_app.core.cache.LaunchCacheMapper
import com.mpfcoding.ichef_app.core.cache.datasource.LaunchCacheDataSource
import com.mpfcoding.ichef_app.core.cache.datasource.LaunchCacheDataSourceImpl
import com.mpfcoding.ichef_app.core.cache.entity.LaunchEntity
import com.mpfcoding.ichef_app.core.cache.service.LaunchDaoService
import com.mpfcoding.ichef_app.core.domain.Launch
import com.mpfcoding.ichef_app.core.utils.EntityMapper
import com.mpfcoding.ichef_app.framework.cache.SharedPrefs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CacheModule {

    @Singleton
    @Provides
    fun provideSharedPrefs(@ApplicationContext context: Context): SharedPrefs {
        return SharedPrefs(context)
    }

    @Singleton
    @Provides
    fun provideLaunchCacheMapper(): EntityMapper<LaunchEntity, Launch> {
        return LaunchCacheMapper()
    }

    @Singleton
    @Provides
    fun provideLaunchCacheDataSource(
        launchDaoService: LaunchDaoService,
        launchCacheMapper: LaunchCacheMapper
    ): LaunchCacheDataSource {
        return LaunchCacheDataSourceImpl(launchDaoService, launchCacheMapper)
    }
}