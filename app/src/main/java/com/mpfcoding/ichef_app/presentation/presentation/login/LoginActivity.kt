package com.mpfcoding.ichef_app.presentation.presentation.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import com.mpfcoding.ichef_app.presentation.presentation.registration.RegistrationUserActivity
import com.mpfcoding.ichef_app.presentation.theme.IChef_appTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@AndroidEntryPoint
class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IChef_appTheme {
                Button(
                    onClick = {
                        startActivity(Intent(this@LoginActivity, RegistrationUserActivity::class.java))
                    }
                ) {
                    Text(text = "Cadastro")
                }
            }
        }
    }
}