package com.mpfcoding.ichef_app.presentation.presentation.registration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mpfcoding.ichef_app.R

class RegistrationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Gray)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp)
                ) {
                    var userName by remember { mutableStateOf(TextFieldValue("")) }

                    OutlinedTextField(
                        value = userName,
                        onValueChange = { userName = it },
                        label = { Text(text = "Nome completo") },
                        placeholder = { Text(text = "Escreva aqui seu nome completo") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp),
                        textStyle = TextStyle(
                            fontSize = 14.sp
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text
                        )
                    )

                    var userEmail by remember { mutableStateOf(TextFieldValue("")) }

                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp),
                        value = userEmail,
                        label = { Text("Email") },
                        placeholder = { Text(text = "Escreva seu E-mail aqui") },
                        onValueChange = { userEmail = it },
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

                    var userPhone by remember { mutableStateOf(TextFieldValue("")) }

                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp),
                        value = userPhone,
                        label = { Text("Telefone") },
                        placeholder = { Text(text = "Escreva seu telefone aqui") },
                        onValueChange = { userPhone = it },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Phone,
                                contentDescription = null
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone
                        )
                    )

                    var userPassword by remember { mutableStateOf(TextFieldValue("")) }
                    var userPasswordVisible by rememberSaveable { mutableStateOf(false) }

                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp),
                        maxLines = 1,
                        singleLine = true,
                        value = userPassword,
                        label = { Text("Senha") },
                        placeholder = { Text(text = "Escreva sua senha aqui") },
                        onValueChange = { userPassword = it },
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
                                painterResource(id = R.drawable.ic_close_lock_24)
                            else
                                painterResource(id = R.drawable.ic_lock_open_24)

                            IconButton(onClick = { userPasswordVisible = !userPasswordVisible }) {
                                Icon(
                                    painter = image,
                                    contentDescription = null
                                )
                            }
                        }
                    )


                    // senha
                    // confirma senha

                    // check promoções

                    // button cadastrar
                }
            }
        }
    }
}