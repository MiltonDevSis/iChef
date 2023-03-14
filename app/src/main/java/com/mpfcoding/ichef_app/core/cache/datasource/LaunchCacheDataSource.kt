package com.mpfcoding.ichef_app.core.cache.datasource

import com.mpfcoding.ichef_app.core.domain.Launch

interface LaunchCacheDataSource {

    suspend fun insert(obj: Launch)

    suspend fun updateQuantity(quantity: Int, id: Int, price: Double)

    suspend fun getAll(): List<Launch>

    suspend fun deleteAll()

    suspend fun sumQuantityLaunchs(): Int
}