package com.mpfcoding.ichef_app.presentation.presentation.dashboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mpfcoding.ichef_app.R
import com.mpfcoding.ichef_app.core.domain.PopularOrder

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PopularOrdersComponent(
    onItemClick: (PopularOrder) -> Unit
) {

    val launchPopular = listOf(
        PopularOrder(
            productId = 2,
            productName = "Pizza Pepperoni",
            productImage = painterResource(id = R.drawable.xis_coracao),
            productPrice = 19.90,
            emptyList()
        ),
        PopularOrder(
            productId = 3,
            productName = "Chesse Burger",
            productImage = painterResource(id = R.drawable.xis_coracao),
            productPrice = 24.90,
            emptyList()
        ),
        PopularOrder(
            productId = 4,
            productName = "Vegetable Pizza",
            productImage = painterResource(id = R.drawable.xis_coracao),
            productPrice = 44.90,
            emptyList()
        )
    )

    LazyRow(
        modifier = Modifier
            .padding(start = 12.dp, top = 6.dp)
    ) {
        items(launchPopular) { item ->
            Card(
                modifier = Modifier
                    .padding(6.dp)
                    .width(140.dp)
                    .height(140.dp),
                elevation = 6.dp,
                shape = RoundedCornerShape(12.dp),
                onClick = { onItemClick(item) }
            ) {
                Column {
                    Text(
                        text = item.productName,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 3.dp, top = 4.dp, end = 3.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.size(12.dp))
                    Image(
                        painter = item.productImage,
                        contentScale = ContentScale.Crop,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 6.dp, top = 4.dp, end = 6.dp)
                            .height(50.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.size(12.dp))
                    Text(
                        text = "R$ ${item.productPrice}",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}