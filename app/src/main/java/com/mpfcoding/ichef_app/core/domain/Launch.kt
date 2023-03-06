package com.mpfcoding.ichef_app.core.domain

import com.mpfcoding.ichef_app.core.cache.entity.LaunchEntity

data class Launch(
    val productId: Int,
    val productName: String,
    val productPrice: Double,
    val productQuantity: Int,
)

fun Launch.toEntity(): LaunchEntity {
    return LaunchEntity(
        productId = productId,
        productName = productName,
        productPrice = productPrice,
        productQuantity = productQuantity
    )
}