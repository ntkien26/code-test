package com.moewsoft.newsapp.domain.usecase

import com.moewsoft.newsapp.domain.common.ResultOf
import com.moewsoft.newsapp.domain.model.Article
import com.moewsoft.newsapp.domain.source.NewsDataSource
import javax.inject.Inject

class GetEverythingUseCase @Inject constructor(private val newsDataSource: NewsDataSource) {

    suspend operator fun invoke(
        keyword: String,
        page: Int,
        pageSize: Int,
        apiKey: String
    ): ResultOf<List<Article>> {
        return newsDataSource.getNews(keyword, page, pageSize, apiKey)
    }
}