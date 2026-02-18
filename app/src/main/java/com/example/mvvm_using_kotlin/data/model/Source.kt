package com.example.mvvm_using_kotlin.data.model

import com.google.gson.annotations.SerializedName

/**
 * @author Shajib
 * since 2/18/26
 */
data class TopHeadlinesResponse(
    @SerializedName("status")
    val status: String = "",
    @SerializedName("totalResults")
    val totalResults: Int = 0,
    @SerializedName("articles")
    val articles: List<Article> = ArrayList(),
)

data class Article(
    @SerializedName("title")
    val title: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("urlToImage")
    val imageUrl: String = "",
    @SerializedName("source")
    val source: Source
)

data class Source(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String = "",
)
