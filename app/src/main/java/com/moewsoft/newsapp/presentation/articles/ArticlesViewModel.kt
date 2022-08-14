package com.moewsoft.newsapp.presentation.articles

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.moewsoft.newsapp.BuildConfig
import com.moewsoft.newsapp.domain.common.*
import com.moewsoft.newsapp.domain.model.Article
import com.moewsoft.newsapp.domain.usecase.GetEverythingUseCase
import com.moewsoft.newsapp.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor(private val useCase: GetEverythingUseCase) :
    BaseViewModel() {

    private val _articles = MutableLiveData<MutableList<Article>>()
    val articles: LiveData<MutableList<Article>> by this::_articles

    private var page = 1
    private val pageSize = 10

    fun getArticles(keyword: String = "apple") {
        viewModelScope.launch {
            showLoading()
            with(useCase(keyword, page, pageSize, BuildConfig.NEW_API_KEY)) {
                doOnSuccess {
                    if (_articles.value.isNullOrEmpty()) {
                        _articles.postValue(it.toMutableList())
                    } else {
                        val currentList = _articles.value
                        currentList?.addAll(it)
                        _articles.postValue(currentList)
                    }
                    dismissLoading()
                }
                doOnFailed {
                    showError(it.message ?: "")
                }
            }
        }
    }

    fun loadMore() {
        page++
        getArticles()
    }
}