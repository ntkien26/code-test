package com.moewsoft.newsapp.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    open val binding by lazy { bindingView() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingView()
        setContentView(binding.root)
        initObserver()
        initConfig(savedInstanceState)
        initListener()
        initTask()
    }

    override fun onDestroy() {
        release()
        super.onDestroy()
    }

    open fun initConfig(savedInstanceState: Bundle?) {}

    open fun initListener() {}

    open fun initObserver() {}

    open fun initTask() {}

    open fun release() {}

    abstract fun bindingView(): T

}