package com.moewsoft.newsapp.presentation.main

import android.content.Context
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.moewsoft.newsapp.R
import com.moewsoft.newsapp.presentation.base.BaseActivity
import com.moewsoft.newsapp.databinding.ActivityMainBinding
import com.moewsoft.newsapp.presentation.articles.ArticlesFragment
import com.moewsoft.newsapp.presentation.detail.DetailArticleFragment
import com.moewsoft.newsapp.presentation.utils.FragmentNavigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(), FragmentNavigator {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun bindingView(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun initConfig(savedInstanceState: Bundle?) {
        super.initConfig(savedInstanceState)
        setSupportActionBar(binding.toolBar)
        openFragment(ArticlesFragment(), false)
    }

    override fun initObserver() {
        super.initObserver()
        mainViewModel.selectedArticleEvent.observe(this) {
            openFragment(DetailArticleFragment(), true)
        }
    }

    override fun openFragment(fragment: Fragment, addToBackStack: Boolean) {
        val beginTransaction = supportFragmentManager.beginTransaction()
        if (addToBackStack) {
            beginTransaction.addToBackStack(fragment::class.java.simpleName)
        }
        beginTransaction.replace(R.id.fragment_container, fragment, fragment::class.java.simpleName)
            .commit()
    }

    override fun setToolBarTitle(title: String) {
        binding.toolbarTitle.text = title
    }

    override fun context(): Context = this
}