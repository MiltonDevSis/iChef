package com.mpfcoding.ichef_app.framework.di

import com.mpfcoding.ichef_app.core.data.UserRemoteDataSource
import com.mpfcoding.ichef_app.core.data.repository.UserRepository
import com.mpfcoding.ichef_app.framework.UserRepositoryImpl
import com.mpfcoding.ichef_app.framework.remote.RetrofitUserDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UserRepositoryModule {

    @Binds
    fun bindUserRepository(repository: UserRepositoryImpl): UserRepository

    @Binds
    fun bindRemoteDataSource(datasource: RetrofitUserDataSource): UserRemoteDataSource
}