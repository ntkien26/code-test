package com.moewsoft.newsapp.presentation.articles

import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import com.moewsoft.newsapp.R
import com.moewsoft.newsapp.databinding.FragmentArticlesBinding
import com.moewsoft.newsapp.presentation.base.BaseFragment
import com.moewsoft.newsapp.presentation.utils.onLastPositionReached
import com.moewsoft.newsapp.presentation.utils.FragmentNavigator
import com.moewsoft.newsapp.presentation.utils.getHostAs
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class ArticlesFragment : BaseFragment<FragmentArticlesBinding>() {

    @Inject
    lateinit var articleAdapter: ArticleAdapter

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
        articlesViewModel.getArticles()
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
}