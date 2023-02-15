package com.mpfcoding.ichef_app.framework.network

import com.mpfcoding.ichef_app.core.domain.Store
import com.mpfcoding.ichef_app.core.network.model.UserRegistrationRequest
import com.mpfcoding.ichef_app.core.utils.Keys
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface IchefApi {

    @Headers("apikey: ${Keys.apikey}")
    @POST("user")
    suspend fun userRegistration(@Body aRequest: UserRegistrationRequest)

    @Headers("apikey: ${Keys.apikey}")
    @GET("user")
    suspend fun getUser(
        @Query("email") email: String,
        @Query("senha") senha: String
    ): List<UserRegistrationRequest>

    @Headers("apikey: ${Keys.apikey}")
    @GET("store")
    suspend fun getStores(): List<Store>
}