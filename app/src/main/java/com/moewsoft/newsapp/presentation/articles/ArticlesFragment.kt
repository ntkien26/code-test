package com.moewsoft.newsapp.presentation.articles

import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import com.moewsoft.newsapp.R
import com.moewsoft.newsapp.databinding.FragmentArticlesBinding
import com.moewsoft.newsapp.presentation.base.BaseFragment
import com.moewsoft.newsapp.presentation.detail.DetailArticleFragment
import com.moewsoft.newsapp.presentation.utils.FragmentNavigator
import com.moewsoft.newsapp.presentation.utils.getHostAs
import com.moewsoft.newsapp.presentation.utils.onLastPositionReached
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ArticlesFragment : BaseFragment<FragmentArticlesBinding>() {

    private val articleAdapter: ArticleAdapter by lazy {
        ArticleAdapter(onItemClicked = {
            getHostAs<FragmentNavigator>()?.openFragment(DetailArticleFragment().apply {
                arguments = bundleOf(DetailArticleFragment.ARG_ARTICLE to it)
            }, true)
        })
    }

    private val articlesViewModel by viewModels<ArticlesViewModel>()

    override fun bindingView(): FragmentArticlesBinding =
        FragmentArticlesBinding.inflate(layoutInflater)

    override fun initConfig() {
        super.initConfig()
        getHostAs<FragmentNavigator>()?.setToolBarTitle(getString(R.string.news))
        with(binding.rcvArticle) {
            onLastPositionReached {
                articlesViewModel.loadMore()
            }
            adapter = articleAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
                ContextCompat.getDrawable(
                    context,
                    R.drawable.line_divider
                )?.let {
                    setDrawable(
                        it
                    )
                }
            })
            itemAnimator = DefaultItemAnimator()
        }
    }

    override fun initObserver() {
        super.initObserver()
        articlesViewModel.articles.observe(this) {
            articleAdapter.set(it)
        }
        articlesViewModel.isLoading.observe(this) { loading ->
            binding.progress.visibility = if (loading) View.VISIBLE else View.GONE
        }
        articlesViewModel.error.observe(this) {
            binding.progress.visibility = View.GONE
        }
    }

    override fun initListener() {
        super.initListener()
        binding.edtQuery.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                articlesViewModel.getArticles(keyword = binding.edtQuery.text.toString())
            }
            return@setOnEditorActionListener true
        }
    }
}