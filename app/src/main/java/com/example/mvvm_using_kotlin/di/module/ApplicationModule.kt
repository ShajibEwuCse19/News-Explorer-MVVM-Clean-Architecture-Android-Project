package com.example.mvvm_using_kotlin.di.module

import android.app.Application
import android.content.Context
import com.example.mvvm_using_kotlin.data.api.HttpHeaderInterceptor
import com.example.mvvm_using_kotlin.data.api.NetworkService
import com.example.mvvm_using_kotlin.di.ApplicationContext
import com.example.mvvm_using_kotlin.di.BaseUrl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author Shajib
 * since 2/18/26
 */
@Module
class ApplicationModule(private val application: Application) {

    @ApplicationContext
    @Provides
    fun provideContext(): Context {
        return application
    }

    @BaseUrl
    @Provides
    fun provideBaseUrl(): String = "https://newsapi.org/v2/"

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideNetworkService(
        @BaseUrl baseUrl: String,
        gsonConverterFactory: GsonConverterFactory
    ): NetworkService {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpHeaderInterceptor())
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(NetworkService::class.java)
    }
}