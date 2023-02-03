package com.mpfcoding.ichef_app.core.domain

import com.mpfcoding.ichef_app.core.network.model.UserRegistrationRequest

data class UserRegistration(
    var name: String = "",
    var email: String = "",
    var phone: String = "",
    var pass: String = "",
    var confirmPass: String = ""
)

fun UserRegistration.toRequest() : UserRegistrationRequest {
    return UserRegistrationRequest(
        nome = name,
        email = email,
        telefone = phone,
        senha = pass
    )
}
