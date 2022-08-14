package com.moewsoft.newsapp.data.mapper

import com.moewsoft.newsapp.data.model.ArticleJsonModel
import com.moewsoft.newsapp.domain.model.Article
import javax.inject.Inject

class ArticleMapper @Inject constructor() {

    fun mapArticle(articleJsonModel: ArticleJsonModel): Article {
        return Article(
            articleJsonModel.author,
            articleJsonModel.image,
            articleJsonModel.title,
            articleJsonModel.description,
            articleJsonModel.publishedAt,
            articleJsonModel.content
        )
    }
}