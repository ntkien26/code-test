package com.moewsoft.newsapp.data

import com.moewsoft.newsapp.data.mapper.ArticleMapper
import com.moewsoft.newsapp.domain.common.Error
import com.moewsoft.newsapp.domain.common.ResultOf
import com.moewsoft.newsapp.domain.common.Success
import com.moewsoft.newsapp.domain.model.Article
import com.moewsoft.newsapp.domain.source.NewsDataSource
import javax.inject.Inject

class NewRepository @Inject constructor(
    private val newService: NewService,
    private val articleMapper: ArticleMapper
) : NewsDataSource {

    override suspend fun getNews(
        keyword: String,
        page: Int,
        pageSize: Int,
        apiKey: String
    ): ResultOf<List<Article>> {
        return try {
            val response = newService.getEverything(keyword, page, pageSize, apiKey)

            if (response.status.equals("ok", ignoreCase = true)) {
                val articles = response.articleJsonModels.map {
                    articleMapper.mapArticle(it)
                }
                Success(articles)
            } else {
                Error(GetEverythingException())
            }
        } catch (error: Exception) {
            Error(error)
        }
    }

}

class GetEverythingException : Exception()