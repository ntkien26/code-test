package com.moewsoft.newsapp.data.model

import com.google.gson.annotations.SerializedName

data class EverythingResponseJsonModel(
    @SerializedName("status")
    val status: String,

    @SerializedName("totalResults")
    val totalResults: Int,

    @SerializedName("articles")
    val articleJsonModels: List<ArticleJsonModel>,
)
