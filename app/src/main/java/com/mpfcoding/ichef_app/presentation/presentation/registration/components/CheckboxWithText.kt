package com.mpfcoding.ichef_app.presentation.presentation.registration.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CheckBoxWithText(
    label: String,
    state: Boolean,
    onStateChange: (Boolean) -> Unit
) {

    val interactionSource = remember { MutableInteractionSource() }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                role = Role.Checkbox,
                onClick = {
                    onStateChange(!state)
                }
            ),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Checkbox(
            checked = state,
            onCheckedChange = null
        )
        Spacer(modifier = Modifier.padding(start = 8.dp))
        Text(
            text = label,
            style = TextStyle(
                fontSize = 14.sp
            )
        )
    }
}