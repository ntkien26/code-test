package com.moewsoft.newsapp.presentation.main

import com.moewsoft.newsapp.domain.model.Article
import com.moewsoft.newsapp.presentation.base.BaseViewModel
import com.moewsoft.newsapp.presentation.common.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel() {

    val selectedArticleEvent = SingleLiveEvent<Article>()
}