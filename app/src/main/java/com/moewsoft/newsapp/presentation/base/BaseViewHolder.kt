package com.moewsoft.newsapp.presentation.base

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/** BaseViewHolder is an abstract class for structuring the base view holder class. */
open class BaseViewHolder(binding: ViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

    val context: Context = binding.root.context

}