package com.mpfcoding.ichef_app.presentation.presentation.registration.components

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import com.mpfcoding.ichef_app.R

@Composable
fun ValidateStrenghPassComponent(
    context: Context,
    password: TextFieldValue,
    isVisible: Boolean
) {
    if (isVisible) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            CheckBoxWithText(
                label = context.getString(R.string.check_strengh_pass_uppercase),
                state = password.text.contains("[A-Z]".toRegex())
            ) {}
            CheckBoxWithText(
                label = context.getString(R.string.check_strengh_pass_lowercase),
                state = password.text.contains("[a-z]".toRegex())
            ) {}
            CheckBoxWithText(
                label = context.getString(R.string.check_strengh_pass_numbers),
                state = password.text.contains("[0-9]".toRegex())
            ) {}
            CheckBoxWithText(
                label = context.getString(R.string.check_strengh_pass_special_characters),
                state = password.text.contains("[!\"#$%&'()*+,-./:;\\\\<=>?@\\[\\]^_`{|}~]".toRegex())
            ) {}
            CheckBoxWithText(
                label = context.getString(R.string.check_strengh_pass_more_eight),
                state = password.text.length > 7
            ) {}
        }
    }
}