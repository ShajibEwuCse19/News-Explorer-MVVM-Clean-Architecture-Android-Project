package com.example.mvvm_using_kotlin.data.repository

import com.example.mvvm_using_kotlin.data.api.NetworkService
import com.example.mvvm_using_kotlin.data.model.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Shajib
 * since 2/18/26
 */
@Singleton
class TopHeadlineRepository @Inject constructor(val networkService: NetworkService) {

    fun getTopHeadlines(country: String): Flow<List<Article>> {
        return flow {
            emit(networkService.getTopHeadlines(country))
        }.map {
            it.articles
        }
    }
}