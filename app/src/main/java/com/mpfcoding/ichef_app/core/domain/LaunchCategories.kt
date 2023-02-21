package com.mpfcoding.ichef_app.core.domain

import androidx.compose.ui.graphics.painter.Painter
import com.mpfcoding.ichef_app.presentation.presentation.dashboard.LaunchCategoriesEnum

data class LaunchCategories(
    val Image: Painter,
    val title: LaunchCategoriesEnum
)
