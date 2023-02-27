package com.mpfcoding.ichef_app.presentation.presentation.dashboard.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

const val EMPTY_CAR_PRODUCTS = 0

@Composable
fun MyFloatingActionButton(
    numItens: Int
) {
    FloatingActionButton(onClick = {}, backgroundColor = Color(0xffFFA000)) {

        Icon(
            imageVector = Icons.Filled.ShoppingCart,
            tint = Color.White,
            contentDescription = null,
            modifier = Modifier.offset(x = 0.dp, y = 3.dp)
        )

        if (EMPTY_CAR_PRODUCTS > 0) {
            Text(
                text = numItens.toString(),
                color = Color.Black,
                style = TextStyle(
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .size(18.dp)
                    .offset(x = 9.dp, y = -(19).dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(Color.Green),
                fontSize = 13.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}