package com.mpfcoding.ichef_app.core.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mpfcoding.ichef_app.core.cache.entity.LaunchEntity

@Dao
interface LaunchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(obj: LaunchEntity)

    @Query("SELECT * FROM launchs")
    suspend fun getAll(): List<LaunchEntity>

    @Query("SELECT SUM(product_quantity) FROM launchs")
    suspend fun sumQuantityLaunchs(): Int
}