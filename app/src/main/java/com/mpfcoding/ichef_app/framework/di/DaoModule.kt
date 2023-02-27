package com.mpfcoding.ichef_app.framework.di

import android.content.Context
import androidx.room.Room
import com.mpfcoding.ichef_app.core.cache.IchefDatabase
import com.mpfcoding.ichef_app.core.cache.dao.LaunchDao
import com.mpfcoding.ichef_app.core.cache.service.LaunchDaoService
import com.mpfcoding.ichef_app.core.cache.service.LaunchDaoServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Singleton
    @Provides
    fun provideDb(@ApplicationContext context: Context): IchefDatabase {
        return Room.databaseBuilder(
            context,
            IchefDatabase::class.java,
            IchefDatabase.DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideLaunchDaoService(dao: LaunchDao): LaunchDaoService {
        return LaunchDaoServiceImpl(dao)
    }

    @Singleton
    @Provides
    fun provideLaunchDao(ichefDatabase: IchefDatabase): LaunchDao {
        return ichefDatabase.launchDao()
    }
}