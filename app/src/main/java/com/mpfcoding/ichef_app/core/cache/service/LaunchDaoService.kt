package com.mpfcoding.ichef_app.core.cache.service

import com.mpfcoding.ichef_app.core.cache.entity.LaunchEntity

interface LaunchDaoService {

    suspend fun insert(obj: LaunchEntity)

    suspend fun getAll(): List<LaunchEntity>

    suspend fun deleteAll()

    suspend fun sumQuantityLaunchs(): Int
}