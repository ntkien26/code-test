package com.moewsoft.newsapp.presentation.main

import androidx.lifecycle.MutableLiveData
import com.moewsoft.newsapp.domain.model.Article
import com.moewsoft.newsapp.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel() {

    val selectedArticleEvent = MutableLiveData<Article>()


}