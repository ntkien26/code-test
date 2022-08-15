package com.moewsoft.newsapp.presentation.detail

import com.bumptech.glide.Glide
import com.moewsoft.newsapp.R
import com.moewsoft.newsapp.databinding.FragmentDetailArticleBinding
import com.moewsoft.newsapp.domain.model.Article
import com.moewsoft.newsapp.presentation.base.BaseFragment
import com.moewsoft.newsapp.presentation.utils.FragmentNavigator
import com.moewsoft.newsapp.presentation.utils.TimeUtils
import com.moewsoft.newsapp.presentation.utils.getHostAs

class DetailArticleFragment : BaseFragment<FragmentDetailArticleBinding>() {

    companion object {
        const val ARG_ARTICLE: String = "ARG_ARTICLE"
    }

    override fun bindingView(): FragmentDetailArticleBinding =
        FragmentDetailArticleBinding.inflate(layoutInflater)

    override fun initConfig() {
        super.initConfig()
        getHostAs<FragmentNavigator>()?.setToolBarTitle(getString(R.string.detail))
        val article = arguments?.getSerializable(ARG_ARTICLE) as Article
        with(binding) {
            Glide.with(this@DetailArticleFragment).load(article.image).into(ivImage)
            tvTitle.text = article.title
            tvContent.text = article.content
            tvUpdatedAt.text = TimeUtils.parseTimeToDDMMYYYY(article.publishedAt)
        }
    }
}