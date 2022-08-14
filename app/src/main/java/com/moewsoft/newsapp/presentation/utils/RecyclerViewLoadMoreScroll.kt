package com.moewsoft.newsapp.presentation.utils

import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.onLastPositionReached(threshold: Int = 1, block: () -> Unit) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            val layoutManager = recyclerView.layoutManager
            if (layoutManager != null && layoutManager.childCount > 0) {
                val indexOfLastItemViewVisible = layoutManager.childCount - 1
                val lastItemViewVisible = layoutManager.getChildAt(indexOfLastItemViewVisible)
                if (lastItemViewVisible != null) {
                    val adapterPosition = layoutManager.getPosition(lastItemViewVisible)
                    val isLastItemVisible = (adapterPosition >= (recyclerView.adapter?.itemCount ?: 0) - threshold)
                    if (isLastItemVisible) {
                        recyclerView.post {
                            block()
                        }
                    }
                }
            }
        }
    })
}