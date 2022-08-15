package com.moewsoft.newsapp

import com.moewsoft.newsapp.domain.source.NewsDataSource
import com.moewsoft.newsapp.domain.usecase.GetEverythingUseCase
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.impl.annotations.SpyK
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@DelicateCoroutinesApi
class GetEverythingUseCaseTest {

    @SpyK
    @InjectMockKs
    private lateinit var getEverythingUseCase: GetEverythingUseCase

    @RelaxedMockK
    lateinit var dataSource: NewsDataSource

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        getEverythingUseCase = GetEverythingUseCase(dataSource)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `data source get news when invoke use case`() = runTest {
        val page = 1
        val keyword = "Apple"
        val apiKey = "A"
        getEverythingUseCase.invoke(keyword = keyword, page = page, 10, apiKey)

        coVerify { dataSource.getNews("Apple", 1, 10, "A") }
    }

}