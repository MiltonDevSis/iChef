package com.mpfcoding.ichef_app.core.data.repository

import com.mpfcoding.ichef_app.core.domain.Store
import com.mpfcoding.ichef_app.core.domain.UserRegistration

interface UserRepository {

    suspend fun userRegistration(userRegistration: UserRegistration)
    suspend fun getUser(email: String, senha: String): Boolean
    suspend fun getStore(): List<Store>
}