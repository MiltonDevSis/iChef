package com.mpfcoding.ichef_app.presentation.presentation.dashboard.components.menuapp

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.mpfcoding.ichef_app.core.utils.TOOLBAR_COLOR
import com.mpfcoding.ichef_app.core.utils.TOOLBAR_CONTENT_COLOR
import com.mpfcoding.ichef_app.core.utils.fromHex

@Composable
fun AppBar() {
    TopAppBar(
        title = {
            Text(text = "XIS DO CHEF - LANCHONETE")
        },
        backgroundColor = Color.fromHex(TOOLBAR_COLOR),
        contentColor = Color.fromHex(TOOLBAR_CONTENT_COLOR)
    )
}