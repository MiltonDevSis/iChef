package com.mpfcoding.ichef_app.presentation.presentation.dashboard.components.menudrawer

import androidx.compose.ui.graphics.painter.Painter

data class MenuItem(
    val id: ItemMenuDrawerId,
    val title: String,
    val contentDescription: String,
    val icon: Painter
)