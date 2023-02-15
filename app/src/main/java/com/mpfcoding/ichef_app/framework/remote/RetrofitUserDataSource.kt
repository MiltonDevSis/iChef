package com.mpfcoding.ichef_app.framework.remote

import com.mpfcoding.ichef_app.core.data.UserRemoteDataSource
import com.mpfcoding.ichef_app.core.domain.Store
import com.mpfcoding.ichef_app.core.network.model.StoreResponse
import com.mpfcoding.ichef_app.core.network.model.UserRegistrationRequest
import com.mpfcoding.ichef_app.framework.network.IchefApi
import javax.inject.Inject

class RetrofitUserDataSource @Inject constructor(
    private val ichefApi: IchefApi
) : UserRemoteDataSource {

    override suspend fun userRegistration(userRegistration: UserRegistrationRequest) {
        return ichefApi.userRegistration(userRegistration)
    }

    override suspend fun getUser(email: String, senha: String): Boolean {
        try {
            val response = ichefApi.getUser("eq.$email", "eq.$senha")
            return response.isNotEmpty()
        } catch (e: Exception) {
            throw Throwable(e.message)
        }
    }

    override suspend fun getStore(): List<StoreResponse> {
        try {
            return ichefApi.getStores()
        } catch (e: Exception) {
            throw Throwable(e.message)
        }
    }
}