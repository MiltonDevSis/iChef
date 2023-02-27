package com.mpfcoding.ichef_app.core.cache.datasource

import com.mpfcoding.ichef_app.core.cache.LaunchCacheMapper
import com.mpfcoding.ichef_app.core.cache.service.LaunchDaoService
import com.mpfcoding.ichef_app.core.domain.Launch
import com.mpfcoding.ichef_app.core.domain.toEntity

class LaunchCacheDataSourceImpl constructor(
    private val daoService: LaunchDaoService,
    private val cacheMapper: LaunchCacheMapper
) : LaunchCacheDataSource {

    override suspend fun insert(obj: Launch) {
        daoService.insert(obj.toEntity())
    }

    override suspend fun getAll(): List<Launch> {
        return cacheMapper.mapFromEntityList(daoService.getAll())
    }

    override suspend fun sumQuantityLaunchs(): Int {
        return daoService.sumQuantityLaunchs()
    }
}