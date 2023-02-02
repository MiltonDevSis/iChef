package com.mpfcoding.ichef_app.presentation.presentation.intro

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mpfcoding.ichef_app.R
import com.mpfcoding.ichef_app.presentation.presentation.intro.components.ButtonIntroScreen
import com.mpfcoding.ichef_app.presentation.presentation.registration.RegistrationActivity
import com.mpfcoding.ichef_app.presentation.theme.IChef_appTheme

class IntroActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IChef_appTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp)
                ) {
                    Spacer(modifier = Modifier.size(20.dp))
                    Image(
                        painterResource(id = R.drawable.logo),
                        contentDescription = "",
                        modifier = Modifier.fillMaxWidth()
                            .width(220.dp)
                            .height(220.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.size(30.dp))
                    ButtonIntroScreen(
                        title = getString(R.string.button_intro_registration_title),
                        subtitle = getString(R.string.button_intro_registration_subtitle),
                        imageId = painterResource(id = R.drawable.ic_fastfood_24),
                        backgroundColor = Color.Green
                    ) {
                        startActivity(Intent(this@IntroActivity, RegistrationActivity::class.java))
                    }
                    Spacer(modifier = Modifier.size(20.dp))
                    ButtonIntroScreen(
                        title = getString(R.string.button_intro_get_order_title),
                        subtitle = getString(R.string.button_intro_get_order_subtitle),
                        imageId = painterResource(id = R.drawable.icon_scooter_64),
                        backgroundColor = Color.Red
                    ) {
                        // tela de estabelecimentos
                    }
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        ClickableText(
                            text = AnnotatedString(
                                getString(R.string.text_intro_i_have_registration)
                            ),
                            onClick = {
                                // tela de login
                            },
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = Color.White,
                                textDecoration = TextDecoration.Underline
                            ),
                            modifier = Modifier
                                .padding(bottom = 6.dp)
                        )
                    }
                }
            }
        }
    }
}