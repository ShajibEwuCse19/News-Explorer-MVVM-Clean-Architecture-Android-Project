package com.example.mvvm_using_kotlin.data.api

import com.example.mvvm_using_kotlin.data.model.TopHeadlinesResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Shajib
 * since 2/18/26
 */
interface NetworkService {

    @GET("/v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String,
//        @Header("X-Api-Key") apiKey: String = API_KEY,
    ): TopHeadlinesResponse
}