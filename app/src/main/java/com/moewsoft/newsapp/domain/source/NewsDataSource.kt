package com.moewsoft.newsapp.domain.source

import com.moewsoft.newsapp.domain.common.ResultOf
import com.moewsoft.newsapp.domain.model.Article

interface NewsDataSource {
    suspend fun getNews(keyword: String, page: Int, pageSize: Int, apiKey: String): ResultOf<List<Article>>
}