package com.mpfcoding.ichef_app.core.cache.service

import com.mpfcoding.ichef_app.core.cache.entity.LaunchEntity

interface LaunchDaoService {

    suspend fun insert(obj: LaunchEntity)

    suspend fun updateQuantity(quantity: Int, id: Int, price: Double)

    suspend fun getAll(): List<LaunchEntity>

    suspend fun deleteAll()

    suspend fun sumQuantityLaunchs(): Int
}