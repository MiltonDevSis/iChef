package com.mpfcoding.ichef_app.framework.di

import com.mpfcoding.ichef_app.BuildConfig
import com.mpfcoding.ichef_app.framework.di.qualifier.BaseUrl
import com.mpfcoding.ichef_app.framework.network.IchefApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val timeOutLimit = 15L

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            setLevel(
                if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else HttpLoggingInterceptor.Level.NONE
            )
        }
    }

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .readTimeout(timeOutLimit, TimeUnit.SECONDS)
            .connectTimeout(timeOutLimit, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory,
    ): IchefApi {
        return Retrofit.Builder()
            .baseUrl("https://uaugumxtleboxylxijvy.supabase.co/rest/v1/")
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()
            .create(IchefApi::class.java)
    }
}