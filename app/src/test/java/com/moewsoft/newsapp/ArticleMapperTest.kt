package com.moewsoft.newsapp

import com.moewsoft.newsapp.data.mapper.ArticleMapper
import com.moewsoft.newsapp.data.model.ArticleJsonModel
import com.moewsoft.newsapp.data.model.SourceJsonModel
import com.moewsoft.newsapp.domain.model.Article
import org.junit.Assert
import org.junit.Test

class ArticleMapperTest {

    private val articleMapper = ArticleMapper()

    @Test
    fun `map article`() {
        val sourceJsonModel = SourceJsonModel(id = null, name = null)
        val articleJsonModel = ArticleJsonModel(sourceJsonModel, "", "", "", "", "", "")
        val article = Article(
            author = "",
            image = "",
            title = "",
            description = "",
            publishedAt = "",
            content = ""
        )
        Assert.assertEquals(articleMapper.mapArticle(articleJsonModel), article)
    }
}