package com.mpfcoding.ichef_app.presentation.presentation.dashboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mpfcoding.ichef_app.R
import com.mpfcoding.ichef_app.presentation.presentation.stores.components.FavoriteButton

@Composable
fun PromoDayComponent(
    modifier: Modifier
) {
    Card(
        modifier = modifier,
        elevation = 4.dp,
        shape = RoundedCornerShape(12.dp)
    ) {

        Row(modifier = Modifier.fillMaxSize()) {

            Image(
                contentScale = ContentScale.Crop,
                painter = painterResource(
                    R.drawable.logo
                ),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(3F, true)
            )

            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(6F, true)
            ) {
                Text(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Promoção do dia",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.size(14.dp))
                Text(
                    fontSize = 14.sp,
                    text = "Xis salada de frango com cheddar",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    fontSize = 14.sp,
                    text = "De R$23.90",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    style = TextStyle(
                        textDecoration = TextDecoration.LineThrough,
                        color = Color.Red
                    )
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    fontSize = 18.sp,
                    text = "por apenas R$19.90",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    style = TextStyle(
                        textDecoration = TextDecoration.LineThrough,
                        color = Color.Green
                    )
                )
            }
        }
    }
}