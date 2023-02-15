package com.mpfcoding.ichef_app.presentation.presentation.stores.components

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mpfcoding.ichef_app.R
import com.mpfcoding.ichef_app.core.domain.Store

@Composable
fun StoreCard(
    store: Store
) {
    Card(
        modifier = Modifier
            .background(Color.White)
            .clickable(
                onClick = {}
            ),
        elevation = 4.dp,
        shape = RoundedCornerShape(12.dp)
    ) {

        Row(modifier = Modifier.fillMaxSize()) {

            Image(
                contentScale = ContentScale.Inside,
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
                    .padding(8.dp)
                    .align(Alignment.CenterVertically)
                    .weight(6F, true)
            ) {
                Text(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    text = store.name
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    fontSize = 14.sp,
                    text = "" +
                            "${store.nameStreet.uppercase()}," +
                            " ${store.numberHouse.uppercase()}," +
                            " ${store.neighborood.uppercase()}," +
                            " ${store.city.uppercase()}" +
                            ""
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Tempo de espera: ${store.timeToDone}"
                )
            }

            FavoriteButton(
                modifier = Modifier
                    .padding(12.dp)
                    .align(Alignment.CenterVertically)
                    .weight(1F, true)
            )
        }
    }
}