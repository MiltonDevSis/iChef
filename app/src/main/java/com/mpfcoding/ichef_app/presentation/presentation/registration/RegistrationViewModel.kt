package com.mpfcoding.ichef_app.presentation.presentation.registration

import androidx.lifecycle.ViewModel
import com.mpfcoding.core.utils.ValidationsUtils
import com.mpfcoding.core.utils.ValidationsUtils.Companion.isPhoneValid
import com.mpfcoding.core.utils.ValidationsUtils.Companion.isValidFullName

class RegistrationViewModel : ViewModel() {

    fun validateFields(
        name: String,
        email: String,
        phone: String,
        pass: String,
        confirmPass: String
    ): UserRegistrationArgs {
        val user = UserRegistrationArgs()

        if (name.isEmpty()) {
            user.errorMessage = "Preencha o campo nome!"
            return user
        }

        if (!name.isValidFullName()) {
            user.errorMessage = "Informe o nome e sobrenome!"
            return user
        }

        if (email.isEmpty()) {
            user.errorMessage = "Preencha o campo email!"
            return user
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            user.errorMessage = "Informe o seu email corretamente!"
            return user
        }

        if (phone.isEmpty()) {
            user.errorMessage = "Preencha o campo telefone!"
            return user
        }

        if (phone.length != 11) {
            user.errorMessage = "Informe o seu telefone corretamente!"
            return user
        }

        if (pass.isEmpty()) {
            user.errorMessage = "Preencha o campo senha!"
            return user
        }

        if (!ValidationsUtils.validatePassword(pass)) {
            user.errorMessage = "Insira uma senha forte"
            return user
        }

        if (confirmPass.isEmpty()) {
            user.errorMessage = "Repita o campo senha!"
            return user
        }

        if (confirmPass != pass) {
            user.errorMessage = "Senhas não conferem"
            return user
        }

        user.isValid = true

        return user
    }
}