package com.mpfcoding.ichef_app.presentation.presentation.shoppingcar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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

@Composable
fun OrderCardComponent() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .clickable(
                onClick = {}
            ),
        elevation = 4.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
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
                    text = "Xis coração",
                    style = TextStyle(
                        fontSize = 20.sp
                    ),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )

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
                        text = "2",
                        style = TextStyle(
                            fontSize = 20.sp
                        ),
                        modifier = Modifier.padding(top = 7.dp)
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
                    .padding(top = 10.dp, bottom = 10.dp),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "R$ 15.90",
                    style = TextStyle(
                        fontSize = 20.sp
                    ),
                    modifier = Modifier.padding(10.dp)
                )

                Text(
                    text = "R$ 54.40",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}