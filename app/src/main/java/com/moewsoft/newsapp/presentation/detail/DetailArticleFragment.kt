package com.moewsoft.newsapp.presentation.detail

import com.moewsoft.newsapp.databinding.FragmentDetailArticleBinding
import com.moewsoft.newsapp.presentation.base.BaseFragment

class DetailArticleFragment : BaseFragment<FragmentDetailArticleBinding>() {

    override fun bindingView(): FragmentDetailArticleBinding =
        FragmentDetailArticleBinding.inflate(layoutInflater)

}