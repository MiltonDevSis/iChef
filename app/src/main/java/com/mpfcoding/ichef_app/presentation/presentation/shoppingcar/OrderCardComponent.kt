package com.mpfcoding.ichef_app.presentation.presentation.shoppingcar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mpfcoding.ichef_app.R
import com.mpfcoding.ichef_app.core.domain.Launch

@Composable
fun OrderComponent(
    orders: List<Launch>
) {
    Column {
        LazyColumn(
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            items(orders) { order ->
                Spacer(modifier = Modifier.size(8.dp))
                OrderCardComponent(order = order)
            }
        }
    }
}

@Composable
fun OrderCardComponent(
    order: Launch
) {
    Card(
        modifier = Modifier
            .background(Color.White)
            .padding(2.dp)
            .clickable(
                onClick = {}
            ),
        elevation = 4.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.xis_coracao),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 10.dp, start = 10.dp)
                    .weight(2F)
            )
            Column(
                modifier = Modifier
                    .weight(2F)
                    .padding(top = 10.dp, bottom = 10.dp),
            ) {
                Text(
                    text = order.productName,
                    style = TextStyle(
                        fontSize = 17.sp
                    ),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.size(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(42.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    IconButton(onClick = {

                    }) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = null,
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                                .background(Color.Green)
                        )
                    }
                    Text(
                        text = order.productQuantity.toString(),
                        style = TextStyle(
                            fontSize = 20.sp
                        ),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    IconButton(onClick = {

                    }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_remove),
                            contentDescription = null,
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                                .background(Color.Green)
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .weight(2F)
                    .padding(top = 10.dp, bottom = 10.dp, end = 8.dp),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "R$ ${order.productPrice}",
                    style = TextStyle(
                        fontSize = 16.sp
                    )
                )
                Spacer(modifier = Modifier.size(30.dp))
                Text(
                    text = "R$ ${sumProducts(order)}",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

fun sumProducts(order: Launch): Int {
    return (order.productQuantity * order.productPrice.toInt())
}