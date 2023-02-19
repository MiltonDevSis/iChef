package com.mpfcoding.ichef_app.core.utils

import androidx.compose.ui.graphics.Color

fun Color.Companion.fromHex(hex: String): Color {
    return Color(android.graphics.Color.parseColor(hex))
}

const val TOOLBAR_COLOR = "#00FF00"
const val TOOLBAR_CONTENT_COLOR = "#000000"
const val DRAWER_HEADER_COLOR = "#00FF00"
