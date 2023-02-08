package com.mpfcoding.ichef_app.presentation.presentation.intro

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
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
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import com.mpfcoding.ichef_app.framework.cache.SharedPrefs
import com.mpfcoding.ichef_app.presentation.presentation.intro.components.ButtonIntroScreen
import com.mpfcoding.ichef_app.presentation.presentation.login.LoginActivity
import com.mpfcoding.ichef_app.presentation.presentation.registration.RegistrationUserActivity
import com.mpfcoding.ichef_app.presentation.theme.IChef_appTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class IntroActivity : ComponentActivity() {

    @Inject
    lateinit var sharedPrefs: SharedPrefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IChef_appTheme {
                Column {
                    TopAppBar(
                        title = { Text(text = "ICHEF APP") },
                        backgroundColor = Color.Green,
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 32.dp, start = 32.dp, end = 32.dp, bottom = 12.dp)
                    ) {
                        Spacer(modifier = Modifier.size(20.dp))
                        Image(
                            painterResource(id = R.drawable.logo),
                            contentDescription = "",
                            modifier = Modifier
                                .fillMaxWidth()
                                .width(220.dp)
                                .height(220.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                        Spacer(modifier = Modifier.size(30.dp))
                        ButtonIntroScreen(
                            title = getString(R.string.button_intro_registration_title),
                            subtitle = getString(R.string.button_intro_registration_subtitle),
                            imageId = painterResource(id = R.drawable.icon_scooter_64),
                            backgroundColor = Color.Green
                        ) {

                        }
                        Spacer(modifier = Modifier.size(20.dp))
                        ButtonIntroScreen(
                            title = getString(R.string.button_intro_get_order_title),
                            subtitle = getString(R.string.button_intro_get_order_subtitle),
                            imageId = painterResource(id = R.drawable.ic_fastfood_24),
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
                                    startActivity(Intent(this@IntroActivity, LoginActivity::class.java))
                                },
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp,
                                    color = Color.White,
                                    textDecoration = TextDecoration.Underline
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}
