package com.mpfcoding.ichef_app.framework.network

import com.mpfcoding.ichef_app.core.network.model.UserRegistrationRequest
import com.mpfcoding.ichef_app.core.utils.Keys
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface IchefApi {

    @Headers("apikey: ${Keys.apikey}")
    @POST("user")
    suspend fun userRegistration(@Body aRequest: UserRegistrationRequest)

}