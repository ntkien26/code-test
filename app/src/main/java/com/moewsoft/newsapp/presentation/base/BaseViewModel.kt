package com.moewsoft.newsapp.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun showLoading() {
        _isLoading.value = true
    }

    fun dismissLoading() {
        _isLoading.value = false
    }

    fun showError(message: String) {
        this._error.value = message
    }

}