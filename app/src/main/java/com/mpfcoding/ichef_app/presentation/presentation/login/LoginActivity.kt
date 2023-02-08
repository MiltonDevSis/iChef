package com.mpfcoding.ichef_app.presentation.presentation.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mpfcoding.ichef_app.R
import com.mpfcoding.ichef_app.presentation.presentation.registration.RegistrationUserActivity
import com.mpfcoding.ichef_app.presentation.presentation.registration.RegistrationViewModel
import com.mpfcoding.ichef_app.presentation.theme.IChef_appTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@AndroidEntryPoint
class LoginActivity : ComponentActivity() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IChef_appTheme {
                Column {
                    TopAppBar(
                        title = { Text(text = "LOGIN") },
                        backgroundColor = Color.Green,
                        navigationIcon = {
                            IconButton(onClick = {
                                finish()
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBack,
                                    contentDescription = "Go Back"
                                )
                            }
                        }
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                    ) {

                        var userEmail by remember { mutableStateOf(TextFieldValue("")) }
                        var userPassword by remember { mutableStateOf(TextFieldValue("")) }
                        var userPasswordVisible by rememberSaveable { mutableStateOf(false) }

                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(2.dp),
                            value = userEmail,
                            label = { Text(getString(R.string.field_complete_email)) },
                            onValueChange = {
                                userEmail = it
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Email,
                                    contentDescription = null
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Email
                            )
                        )

                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(2.dp),
                            maxLines = 1,
                            singleLine = true,
                            value = userPassword,
                            label = { Text(getString(R.string.field_complete_password)) },
                            onValueChange = {
                                userPassword = it
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Lock,
                                    contentDescription = null
                                )
                            },
                            visualTransformation = if (userPasswordVisible)
                                VisualTransformation.None
                            else
                                PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Password
                            ),
                            trailingIcon = {
                                val image = if (userPasswordVisible)
                                    painterResource(id = R.drawable.ic_eye_close)
                                else
                                    painterResource(id = R.drawable.ic_eye_open)

                                IconButton(onClick = {
                                    userPasswordVisible = !userPasswordVisible
                                }) {
                                    Icon(
                                        painter = image,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .width(24.dp)
                                            .height(24.dp)
                                    )
                                }
                            }
                        )

                        ClickableText(
                            text = AnnotatedString(
                                "Esqueci minha senha"
                            ),
                            onClick = {},
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = Color.White,
                                textDecoration = TextDecoration.Underline,
                                textAlign = TextAlign.Center
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp)
                        )

                        Button(
                            onClick = {
                                startActivity(
                                    Intent(
                                        this@LoginActivity,
                                        RegistrationUserActivity::class.java
                                    )
                                )
                            },
                            enabled = viewModel.isValidFields(userEmail.text, userPassword.text),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp)
                                .padding(top = 10.dp),
                            content = { Text(text = "ENTRAR") }
                        )

                        Button(
                            onClick = {},
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp)
                                .padding(top = 10.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(R.color.facebook_color),
                                contentColor = Color.White
                            ),
                            content = { Text(text = "ENTRAR COM FACABOOK") }
                        )

                        Text(
                            text = "AINDA NÃO TEM LOGIN?",
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp)
                        )

                        Button(
                            onClick = {
                                startActivity(
                                    Intent(
                                        this@LoginActivity,
                                        RegistrationUserActivity::class.java
                                    )
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .padding(horizontal = 50.dp)
                                .padding(top = 10.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Green,
                                contentColor = Color.White
                            ),
                            content = { Text(text = "CADASTRE-SE") }
                        )
                    }
                }
            }
        }
    }
}