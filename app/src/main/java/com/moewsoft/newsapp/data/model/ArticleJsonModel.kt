package com.moewsoft.newsapp.data.model

import com.google.gson.annotations.SerializedName

data class ArticleJsonModel(
    @SerializedName("source")
    val sourceJsonModel: SourceJsonModel,

    @SerializedName("author")
    val author: String,

    @SerializedName("urlToImage")
    val image: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("publishedAt")
    val publishedAt: String,

    @SerializedName("content")
    val content: String,
)
