package com.mpfcoding.ichef_app.presentation.presentation.registration

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.lifecycle.lifecycleScope
import com.mpfcoding.ichef_app.R
import com.mpfcoding.ichef_app.core.domain.UserRegistration
import com.mpfcoding.ichef_app.core.utils.IchefConstants
import com.mpfcoding.ichef_app.core.utils.TOOLBAR_COLOR
import com.mpfcoding.ichef_app.core.utils.TOOLBAR_CONTENT_COLOR
import com.mpfcoding.ichef_app.core.utils.fromHex
import com.mpfcoding.ichef_app.framework.cache.SharedPrefs
import com.mpfcoding.ichef_app.presentation.presentation.registration.components.TextTermsClickable
import com.mpfcoding.ichef_app.presentation.presentation.registration.components.ValidateStrenghPassComponent
import com.mpfcoding.ichef_app.presentation.theme.IChef_appTheme
import dagger.hilt.android.AndroidEntryPoint
import es.dmoral.toasty.Toasty
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class RegistrationUserActivity : ComponentActivity() {

    private val viewModel: RegistrationViewModel by viewModels()

    @Inject
    lateinit var sharedPrefs: SharedPrefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IChef_appTheme {
                Column {
                    TopAppBar(
                        title = { Text(text = "CADASTRO") },
                        backgroundColor = Color.fromHex(TOOLBAR_COLOR),
                        contentColor = Color.fromHex(TOOLBAR_CONTENT_COLOR),
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
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(14.dp)
                        ) {

                            var userName by remember { mutableStateOf(TextFieldValue("")) }
                            var userEmail by remember { mutableStateOf(TextFieldValue("")) }
                            var userPhone by remember { mutableStateOf(TextFieldValue("")) }
                            var userPassword by remember { mutableStateOf(TextFieldValue("")) }
                            var userPasswordVisible by rememberSaveable { mutableStateOf(false) }
                            var userConfirmPass by remember { mutableStateOf(TextFieldValue("")) }
                            var userConfirmPassVisible by rememberSaveable { mutableStateOf(false) }

                            OutlinedTextField(
                                value = userName,
                                onValueChange = {
                                    userName = it
                                },
                                label = { Text(text = getString(R.string.field_complete_name)) },
                                modifier = Modifier
                                    .fillMaxWidth(),
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
                                value = userPhone,
                                label = { Text(getString(R.string.field_complete_phone)) },
                                onValueChange = {
                                    if (it.text.length <= 11)
                                        userPhone = it
                                },
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

                            OutlinedTextField(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(2.dp),
                                maxLines = 1,
                                singleLine = true,
                                value = userConfirmPass,
                                label = {
                                    Text(text = getString(R.string.field_complete_confirm_password))
                                },
                                onValueChange = { userConfirmPass = it },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Lock,
                                        contentDescription = null
                                    )
                                },
                                visualTransformation = if (userConfirmPassVisible)
                                    VisualTransformation.None
                                else
                                    PasswordVisualTransformation(),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Password
                                ),
                                trailingIcon = {
                                    val image = if (userConfirmPassVisible)
                                        painterResource(id = R.drawable.ic_eye_close)
                                    else
                                        painterResource(id = R.drawable.ic_eye_open)

                                    IconButton(onClick = {
                                        userConfirmPassVisible = !userConfirmPassVisible
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

                            Spacer(modifier = Modifier.size(5.dp))

                            ValidateStrenghPassComponent(
                                this@RegistrationUserActivity,
                                password = userPassword,
                                isVisible = userPassword.text.isNotEmpty()
                            )

//                    CheckBoxWithText(
//                        getString(R.string.check_receive_offers),
//                        checkBoxState
//                    ) {
//                        checkBoxState = it
//                    }

                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(8.dp),
                                verticalArrangement = Arrangement.Bottom
                            ) {
                                TextTermsClickable(
                                    this@RegistrationUserActivity,
                                    getString(R.string.text_first_part_terms_of_use),
                                    getString(R.string.text_second_clikable_terms_of_use),
                                    getString(R.string.url_google)
                                )
                                Spacer(modifier = Modifier.size(12.dp))
                                Button(
                                    onClick = {
                                        val isValidFields = viewModel.validateFields(
                                            userName.text,
                                            userEmail.text,
                                            userPhone.text,
                                            userPassword.text,
                                            userConfirmPass.text
                                        )

                                        if (isValidFields.isValid) {
                                            val user = UserRegistration(
                                                name = userName.text,
                                                email = userEmail.text,
                                                phone = userPhone.text,
                                                pass = userPassword.text
                                            )
                                            lifecycleScope.launch {
                                                viewModel.montaRequest(user)
                                            }
                                            Toasty.success(
                                                this@RegistrationUserActivity,
                                                "Cadastro realizado com sucesso!",
                                                Toast.LENGTH_LONG
                                            ).show()
                                            sharedPrefs.putString(
                                                key = IchefConstants.UserLogged.USER_LOGGED,
                                                value = userName.text
                                            )
                                            finish()
                                        } else {
                                            Toasty.warning(
                                                this@RegistrationUserActivity,
                                                isValidFields.errorMessage,
                                                Toast.LENGTH_LONG
                                            ).show()
                                        }
                                    },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(40.dp)
                                ) {
                                    Text(text = getString(R.string.button_registration))
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.size(10.dp))
                }
            }
        }
    }
}