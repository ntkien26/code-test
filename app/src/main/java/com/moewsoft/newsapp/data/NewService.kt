package com.moewsoft.newsapp.data

import com.moewsoft.newsapp.data.model.EverythingResponseJsonModel
import retrofit2.http.GET
import retrofit2.http.Query

interface NewService {

    @GET("everything")
    suspend fun getEverything(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int,
        @Query("apiKey") apiKey: String,
        ): EverythingResponseJsonModel
}