package com.mpfcoding.ichef_app.presentation.presentation.registration.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

@Composable
fun TextTermsClickable(
    context: Context,
    text: String,
    textClickable: String,
    url: String
) {
    val annotatedText = buildAnnotatedString {
        append(text)

        pushStringAnnotation(
            tag = "URL",
            annotation = url
        )
        withStyle(style = SpanStyle(color = Color.Blue,
            fontWeight = FontWeight.Bold)) {
            append(textClickable)
        }

        pop()
    }

    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            annotatedText.getStringAnnotations(
                tag = "URL",
                start = offset,
                end = offset
            ).firstOrNull()?.let {
                Toast.makeText(
                    context,
                    textClickable,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    )
}