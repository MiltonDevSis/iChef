package com.mpfcoding.ichef_app.core.data

import com.mpfcoding.ichef_app.core.network.model.UserRegistrationRequest

interface UserRemoteDataSource {

    suspend fun userRegistration(userRegistration: UserRegistrationRequest)
}