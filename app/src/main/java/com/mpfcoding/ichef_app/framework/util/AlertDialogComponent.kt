package com.mpfcoding.ichef_app.framework.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy

@Composable
fun AlertDialogComponent(
    showDialog: Boolean,
    clickYes: () -> Unit,
    clickNo: () -> Unit
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = clickNo,
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                securePolicy = SecureFlagPolicy.Inherit
            ),
            title = {
                Text(
                    text = "Atenção",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(1.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                )
            },
            text = {
                Text(text = "Você realmente deseja sair do aplicativo?")
            },
            buttons = {
                OutlinedButton(
                    shape = RoundedCornerShape(percent = 30),
                    onClick = {
                        clickNo()
                    },
                    modifier = Modifier
                        .padding(top = 4.dp, start = 16.dp, end = 16.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "Não")
                }
                Spacer(modifier = Modifier.width(6.dp))
                OutlinedButton(
                    shape = RoundedCornerShape(percent = 30),
                    onClick = {
                        clickYes()
                    },
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = Color(0xff8BC34A),
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .padding(top = 4.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "Sim")
                }
            }
        )
    }
}