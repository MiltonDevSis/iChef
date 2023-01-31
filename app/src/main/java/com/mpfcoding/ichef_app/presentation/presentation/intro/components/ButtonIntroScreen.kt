package com.mpfcoding.ichef_app.presentation.presentation.intro.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonIntroScreen(
    title: String,
    subtitle: String,
    imageId: Painter,
    backgroundColor: Color,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
    ) {
        Row(
            modifier = Modifier
                .height(100.dp)
                .background(backgroundColor)
                .clickable(onClick = onClick)
        ) {
            Image(
                imageId,
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(16.dp)
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    ),
                    modifier = Modifier.padding(top = 6.dp)
                )
                Text(
                    text = subtitle,
                    style = TextStyle(
                        fontSize = 14.sp
                    ),
                    modifier = Modifier.padding(top = 6.dp)
                )
            }
        }
    }
}
