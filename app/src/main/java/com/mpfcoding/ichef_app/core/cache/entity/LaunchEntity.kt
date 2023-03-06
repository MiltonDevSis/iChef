package com.mpfcoding.ichef_app.core.cache.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "launchs")
data class LaunchEntity(
    @PrimaryKey(autoGenerate = true)
    val productId: Int?,
    @ColumnInfo(name = "product_name")
    val productName: String,
    @ColumnInfo(name = "product_price")
    val productPrice: Double,
    @ColumnInfo(name = "product_quantity")
    val productQuantity: Int
)