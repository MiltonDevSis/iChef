package com.mpfcoding.ichef_app.core.data

import com.mpfcoding.ichef_app.core.domain.Store
import com.mpfcoding.ichef_app.core.network.model.UserRegistrationRequest
import com.mpfcoding.ichef_app.core.network.util.BaseResponse

interface UserRemoteDataSource {

    suspend fun userRegistration(userRegistration: UserRegistrationRequest)
    suspend fun getUser(email: String, senha: String): Boolean
    suspend fun getStore(): List<Store>
}