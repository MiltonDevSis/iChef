package com.mpfcoding.ichef_app.presentation.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mpfcoding.ichef_app.presentation.theme.IChef_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IChef_appTheme {

            }
        }
    }
}