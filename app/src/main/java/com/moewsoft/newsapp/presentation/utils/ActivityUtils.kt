package com.moewsoft.newsapp.presentation.utils

import android.content.Context
import androidx.fragment.app.Fragment

interface FragmentNavigator {

    fun openFragment(fragment: Fragment, addToBackStack: Boolean)

    fun setToolBarTitle(title: String)

    fun context(): Context
}

inline fun <reified T> Fragment.getHostAs(): T? = when {
    parentFragment is T -> parentFragment as T
    activity is T -> activity as T
    else -> null
}