package com.moewsoft.newsapp.data.model

import com.google.gson.annotations.SerializedName

data class SourceJsonModel(
    @SerializedName("id")
    val id: String?,

    @SerializedName("name")
    val name: String?
)
