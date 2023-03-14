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

    @Query("UPDATE launchs SET product_quantity = :quantity, total_price_order = :quantity * :price WHERE productId = :id")
    suspend fun updateQuantityOrder(quantity: Int, id: Int, price: Double)

    @Query("SELECT total_price_order FROM launchs WHERE productId = :itemId")
    fun getTotal(itemId: Int): Double

    @Query("SELECT * FROM launchs")
    suspend fun getAll(): List<LaunchEntity>

    @Query("DELETE FROM launchs")
    suspend fun deleteAll()

    @Query("SELECT SUM(product_quantity) FROM launchs")
    suspend fun sumQuantityLaunchs(): Int
}