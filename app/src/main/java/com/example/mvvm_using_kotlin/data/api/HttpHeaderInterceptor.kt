package com.example.mvvm_using_kotlin.data.api

import com.example.mvvm_using_kotlin.utils.AppConstant.API_KEY
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author Shajib
 * since 2/18/26
 */
class HttpHeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .addHeader("X-Api-Key", API_KEY)
            .build()
        return chain.proceed(newRequest)
    }
}