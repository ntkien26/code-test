package com.moewsoft.newsapp.domain.model

import java.io.Serializable

data class Article(
    val author: String? = null,

    val image: String? = null,

    val title: String? = null,

    val description: String? = null,

    val publishedAt: String? = null,

    val content: String? = null,
): Serializable