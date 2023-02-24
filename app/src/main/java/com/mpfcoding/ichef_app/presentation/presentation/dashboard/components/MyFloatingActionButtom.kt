package com.mpfcoding.ichef_app.presentation.presentation.dashboard.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun MyFloatingActionButton(){
    FloatingActionButton(
        onClick = {},
        backgroundColor = Color(0xffFFA000)
    ) {
        Icon(
            Icons.Filled.ShoppingCart, tint = Color.White,
            contentDescription = null
        )
    }
}