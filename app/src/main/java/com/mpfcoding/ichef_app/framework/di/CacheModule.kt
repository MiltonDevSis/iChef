package com.mpfcoding.ichef_app.framework.di

import android.content.Context
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
}