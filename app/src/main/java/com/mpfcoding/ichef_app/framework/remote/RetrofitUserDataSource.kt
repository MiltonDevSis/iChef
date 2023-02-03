package com.mpfcoding.ichef_app.framework.remote

import com.mpfcoding.ichef_app.core.data.UserRemoteDataSource
import com.mpfcoding.ichef_app.core.network.model.UserRegistrationRequest
import com.mpfcoding.ichef_app.framework.network.IchefApi
import javax.inject.Inject

class RetrofitUserDataSource @Inject constructor(
    private val ichefApi: IchefApi
): UserRemoteDataSource {

    override suspend fun userRegistration(userRegistration: UserRegistrationRequest) {
        return ichefApi.userRegistration(userRegistration)
    }
}