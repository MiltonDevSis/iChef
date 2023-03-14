package com.mpfcoding.ichef_app.presentation.presentation.shoppingcar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.*
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
    orders: List<Launch>,
    viewModel: ShoppingCarViewModel
) {
    Column {
        LazyColumn(
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            items(orders) { order ->
                Spacer(modifier = Modifier.size(8.dp))
                OrderCardComponent(order = order, viewModel)
            }
        }
    }
}

@Composable
fun OrderCardComponent(
    order: Launch,
    viewModel: ShoppingCarViewModel
) {

    var totalItem by remember { mutableStateOf(0) }
    var priceItem by remember { mutableStateOf(0.0) }

    totalItem = order.productQuantity
    priceItem = order.productPrice

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
                    .weight(2.6F)
                    .align(Alignment.CenterVertically)
            )
            Column(
                modifier = Modifier
                    .weight(4F)
                    .padding(top = 10.dp, bottom = 10.dp),
            ) {
                Text(
                    text = order.productName,
                    style = TextStyle(
                        fontSize = 17.sp
                    ),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .fillMaxSize()
                )
                Spacer(modifier = Modifier.size(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(42.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    IconButton(onClick = {
                        totalItem += 1
                        viewModel.updateQuantity(totalItem, order.productId, order.productPrice)
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = null,
                            modifier = Modifier
                                .width(24.dp)
                                .height(24.dp)
                                .background(Color.Green)
                        )
                    }
                    Text(
                        text = totalItem.toString(),
                        style = TextStyle(
                            fontSize = 20.sp
                        ),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    IconButton(onClick = {
                        if (totalItem > 0) {
                            totalItem -= 1
                            viewModel.updateQuantity(totalItem, order.productId, order.productPrice)
                        }
                    }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_remove),
                            contentDescription = null,
                            modifier = Modifier
                                .width(24.dp)
                                .height(24.dp)
                                .background(Color.Green)
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .weight(1.4F)
                    .padding(top = 10.dp, bottom = 10.dp, end = 8.dp)
                    .align(Alignment.CenterVertically),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "R$ $priceItem",
                    style = TextStyle(
                        fontSize = 15.sp
                    )
                )
                Spacer(modifier = Modifier.size(35.dp))
                Text(
                    text = "R$ ${sumProducts(totalItem, priceItem)}",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

fun sumProducts(quantity: Int, priceItem: Double): Int {
    return (quantity * priceItem.toInt())
}