package com.mpfcoding.ichef_app.presentation.presentation.registration

data class UserRegistration(
    var name: String = "",
    var email: String = "",
    var phone: String = "",
    var pass: String = "",
    var confirmPass: String = ""
)
