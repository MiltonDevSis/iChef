package com.mpfcoding.ichef_app.core.cache.service

import com.mpfcoding.ichef_app.core.cache.dao.LaunchDao
import com.mpfcoding.ichef_app.core.cache.entity.LaunchEntity

class LaunchDaoServiceImpl constructor(
    private val launchDao: LaunchDao
): LaunchDaoService {

    override suspend fun insert(obj: LaunchEntity) {
        launchDao.insert(obj)
    }

    override suspend fun getAll(): List<LaunchEntity> {
        return launchDao.getAll()
    }

    override suspend fun sumQuantityLaunchs(): Int {
        return launchDao.sumQuantityLaunchs()
    }
}