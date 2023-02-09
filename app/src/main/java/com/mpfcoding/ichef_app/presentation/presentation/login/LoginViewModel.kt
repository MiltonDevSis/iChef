package com.mpfcoding.ichef_app.presentation.presentation.login

import androidx.lifecycle.ViewModel
import com.mpfcoding.ichef_app.core.data.repository.UserRepository
import com.mpfcoding.ichef_app.core.domain.UserRegistration
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {

    suspend fun montaRequest(email: String, senha: String): Boolean {
        return userRepository.getUser(email, senha)
    }

    fun isValidFields(email: String, password: String): Boolean {

        val isValidEmail = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isValidPass = password.length > 7

        return isValidEmail && isValidPass
    }
}