package com.moewsoft.newsapp

import com.moewsoft.newsapp.data.GetEverythingException
import com.moewsoft.newsapp.data.NewRepository
import com.moewsoft.newsapp.data.NewService
import com.moewsoft.newsapp.data.mapper.ArticleMapper
import com.moewsoft.newsapp.data.model.ArticleJsonModel
import com.moewsoft.newsapp.data.model.EverythingResponseJsonModel
import com.moewsoft.newsapp.data.model.SourceJsonModel
import com.moewsoft.newsapp.domain.common.Error
import com.moewsoft.newsapp.domain.common.Success
import com.moewsoft.newsapp.domain.model.Article
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class NewRepositoryTest {

    private val articleMapper = ArticleMapper()

    private lateinit var newRepository: NewRepository

    @MockK(relaxed = true)
    lateinit var newService: NewService

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        newRepository = NewRepository(newService, articleMapper)
    }

    @Test
    fun `get news success`() = runTest {
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

        coEvery {
            newService.getEverything("apple", 1, 10, "")
        } returns EverythingResponseJsonModel(status = "ok", 10, mutableListOf(articleJsonModel))

        val result = newRepository.getNews("apple", 1, 10, "")

        Assert.assertEquals(
            (result as Success).data,
            mutableListOf(article)
        )
    }

    @Test
    fun `get news error`() = runTest {
        val sourceJsonModel = SourceJsonModel(id = null, name = null)
        val articleJsonModel = ArticleJsonModel(sourceJsonModel, "", "", "", "", "", "")

        coEvery {
            newService.getEverything("apple", 1, 10, "")
        } returns EverythingResponseJsonModel(status = "notOK", 10, mutableListOf(articleJsonModel))

        val result = newRepository.getNews("apple", 1, 10, "")

        Assert.assertTrue(result is Error)
    }
}