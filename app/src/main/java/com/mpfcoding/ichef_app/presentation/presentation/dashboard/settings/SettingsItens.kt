package com.mpfcoding.ichef_app.presentation.presentation.dashboard.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingsItens(
    modifier: Modifier = Modifier,
    image: Painter,
    title: String,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .clickable { onClick() }
            .fillMaxWidth()
    ) {

        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 24.dp, start = 24.dp, end = 24.dp)
        ) {
            Image(
                image,
                contentDescription = null,
                modifier = Modifier
                    .size(42.dp)
                    .padding(end = 16.dp)
            )
            Text(
                text = title,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                ),
                modifier = Modifier.padding(top = 6.dp)
            )
        }
        Spacer(modifier = Modifier.size(12.dp))
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(Color.Green)
        )
    }
}
