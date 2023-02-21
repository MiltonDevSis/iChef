package com.mpfcoding.ichef_app.presentation.presentation.dashboard.components.menuapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mpfcoding.ichef_app.R

@Composable
fun MyBottomAppBarComponent(
    onHome: ((type: String) -> Unit)
) {
    BottomAppBar(
        cutoutShape = CircleShape,
        content = {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                IconButton(
                    onClick = { onHome("Home") }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_home),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp)
                    )
                }

                IconButton(
                    onClick = {  }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp)
                    )
                }

                IconButton(onClick = {}) {}

                IconButton(onClick = {  }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_message),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp)
                    )
                }

                IconButton(
                    onClick = {  }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_settings),
                        contentDescription = null,
                        modifier = Modifier.size(25.dp)
                    )
                }
            }
        }
    )
}