package com.moewsoft.newsapp.presentation.base

import androidx.recyclerview.widget.RecyclerView


abstract class BaseRecyclerViewAdapter<T>(
    var currentList: MutableList<T> = mutableListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun add(itemList: List<T>) {
        val size = this.currentList.size
        this.currentList.addAll(itemList)
        val sizeNew = this.currentList.size
        notifyItemRangeChanged(size, sizeNew)
    }

    fun addAt(position: Int, item: T) {
        currentList.add(position, item)
        val sizeNew = this.currentList.size
        notifyDataSetChanged()
    }

    fun setAt(position: Int, item: T) {
        currentList[position] = item
        notifyItemChanged(position)
    }

    fun getItemAt(position: Int): T {
        return currentList[position]
    }

    open fun set(newData: List<T>) {
        val clone: List<T> = ArrayList(newData)
        currentList.clear()
        currentList.addAll(clone)
        notifyDataSetChanged()
    }

    fun removeAt(position: Int) {
        currentList.removeAt(position)
        notifyDataSetChanged()
    }

    fun clear() {
        currentList.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = currentList.size

}