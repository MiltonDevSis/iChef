package com.mpfcoding.ichef_app.presentation.presentation.login

import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    fun isValidFields(email: String, password: String): Boolean {

        val isValidEmail = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isValidPass = password.length > 7

        return isValidEmail && isValidPass
    }
}