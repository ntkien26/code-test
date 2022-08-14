package com.moewsoft.newsapp.presentation.articles

import androidx.recyclerview.widget.DiffUtil
import com.moewsoft.newsapp.domain.model.Article

class ArticleComparator(private val oldList: List<Article>, private val newList: List<Article>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size
    override fun getNewListSize(): Int = newList.size
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].title == newList[newItemPosition].title
    }

    override fun areContentsTheSame(oldCourse: Int, newPosition: Int): Boolean {
        return oldList[oldCourse] == newList[newPosition]
    }

}