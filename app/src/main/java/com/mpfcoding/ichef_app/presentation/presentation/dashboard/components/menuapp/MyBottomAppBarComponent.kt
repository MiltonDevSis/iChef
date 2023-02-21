package com.mpfcoding.ichef_app.presentation.presentation.dashboard.components.menuapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
    onOrder: (() -> Unit),
    onLocation: (() -> Unit),
    onConfigs: (() -> Unit),
    onProfile: (() -> Unit)
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
                    onClick = { onOrder.invoke() }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_pedidos),
                        contentDescription = null
                    )
                }

                IconButton(
                    onClick = { onLocation.invoke() }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_meus_enderecos),
                        contentDescription = null
                    )
                }

                IconButton(onClick = {}) {}

                IconButton(onClick = { onConfigs.invoke() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_configs),
                        contentDescription = null
                    )
                }

                IconButton(onClick = { onProfile.invoke() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_user),
                        contentDescription = null
                    )
                }
            }
        }
    )
}