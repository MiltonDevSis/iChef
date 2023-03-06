package com.mpfcoding.ichef_app.core.domain

import androidx.compose.ui.graphics.painter.Painter

data class PopularOrder(
    val productId: Int,
    val productName: String,
    val productImage: Painter,
    val productPrice: Double,
    val listIngredients: List<String>
)