package com.moewsoft.newsapp.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T : ViewBinding> : Fragment() {

    open val binding by lazy { bindingView()  }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
        initConfig()
        initListener()
    }

    override fun onDestroyView() {
        release()
        super.onDestroyView()
    }

    open fun initObserver() {}

    open fun initConfig() {}

    open fun initListener() {}

    open fun release() {}

    abstract fun bindingView() : T

}