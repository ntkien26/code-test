package com.moewsoft.newsapp.di

import com.moewsoft.newsapp.data.NewRepository
import com.moewsoft.newsapp.domain.source.NewsDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindNewDataSource(
        newsDataSource: NewRepository
    ): NewsDataSource
}