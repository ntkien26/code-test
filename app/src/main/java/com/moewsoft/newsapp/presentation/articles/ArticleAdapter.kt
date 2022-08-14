package com.moewsoft.newsapp.presentation.articles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.moewsoft.newsapp.databinding.ItemArticleBinding
import com.moewsoft.newsapp.domain.model.Article
import com.moewsoft.newsapp.presentation.base.BaseRecyclerViewAdapter
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject


@FragmentScoped
class ArticleAdapter @Inject constructor() :
    BaseRecyclerViewAdapter<Article>() {

    private var mScrollListener: RecyclerView.OnScrollListener? = null

    inner class ArticleHolder(val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun set(newData: List<Article>) {
        super.set(newData)
        val diffResult = DiffUtil.calculateDiff(ArticleComparator(currentList, newData))
        currentList.clear()
        currentList.addAll(newData)
        diffResult.dispatchUpdatesTo(this)
    }

    fun setScrollListener(scrollListener: RecyclerView.OnScrollListener) {
        this.mScrollListener = scrollListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ArticleHolder(ItemArticleBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ArticleHolder) {
            val data = currentList[position]

            with(holder.binding) {
                Glide.with(holder.itemView).load(data.image).into(ivImage)
                tvTitle.text = data.title
                tvDescription.text = data.description
                tvUpdatedAt.text = data.publishedAt
            }
        }
    }
}