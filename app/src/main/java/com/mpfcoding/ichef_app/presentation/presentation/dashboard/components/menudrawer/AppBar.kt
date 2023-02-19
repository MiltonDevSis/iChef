package com.mpfcoding.ichef_app.presentation.presentation.dashboard.components.menudrawer

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.mpfcoding.ichef_app.core.utils.TOOLBAR_COLOR
import com.mpfcoding.ichef_app.core.utils.TOOLBAR_CONTENT_COLOR
import com.mpfcoding.ichef_app.core.utils.fromHex

@Composable
fun AppBar(
    onNavigationIconClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = "XIS DO CHEF - LANCHONETE")
        },
        backgroundColor = Color.fromHex(TOOLBAR_COLOR),
        contentColor = Color.fromHex(TOOLBAR_CONTENT_COLOR),
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null
                )
            }
        }
    )
}