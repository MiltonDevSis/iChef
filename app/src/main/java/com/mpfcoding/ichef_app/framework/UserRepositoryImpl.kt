package com.mpfcoding.ichef_app.framework

import com.mpfcoding.ichef_app.core.data.UserRemoteDataSource
import com.mpfcoding.ichef_app.core.data.repository.UserRepository
import com.mpfcoding.ichef_app.core.domain.UserRegistration
import com.mpfcoding.ichef_app.core.domain.toRequest
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dataSource: UserRemoteDataSource
) : UserRepository {

    override suspend fun userRegistration(userRegistration: UserRegistration) {
        dataSource.userRegistration(userRegistration = userRegistration.toRequest())
    }

    override suspend fun getUser(email: String, senha: String): Boolean {
        return dataSource.getUser(email, senha)
    }
}