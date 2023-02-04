package com.mpfcoding.ichef_app.presentation.presentation.registration.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun ValidateStrenghPassComponent(
    password: TextFieldValue,
    isVisible: Boolean
) {
    if (isVisible) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            CheckBoxWithText(
                label = "Conter uma letra maiúscula",
                state = password.text.contains("[A-Z]".toRegex())
            ) {}
            CheckBoxWithText(
                label = "Conter uma letra minúscula",
                state = password.text.contains("[a-z]".toRegex())
            ) {}
            CheckBoxWithText(
                label = "Conter números",
                state = password.text.contains("[0-9]".toRegex())
            ) {}
            CheckBoxWithText(
                label = "Conter um caracter especial (!@#$%¨&*())",
                state = password.text.contains("[!\"#$%&'()*+,-./:;\\\\<=>?@\\[\\]^_`{|}~]".toRegex())
            ) {}
            CheckBoxWithText(
                label = "Conter 8 ou mais caracteres",
                state = password.text.length > 7
            ) {}
        }
    }
}