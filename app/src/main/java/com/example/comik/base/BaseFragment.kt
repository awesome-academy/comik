package com.example.comik.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.comik.utils.showToast

abstract class BaseFragment<V : ViewDataBinding> : Fragment() {

    @get:LayoutRes
    protected abstract val layoutResources: Int
    protected var binding: V? = null
    abstract val viewModel: RxViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil
        .inflate<V>(inflater, layoutResources, container, false)
        .apply { binding = this }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.error.observe(viewLifecycleOwner, Observer {
            view.context.showToast(it)
        })
        setupViews()
        initData()
        initActions()
    }

    protected abstract fun setupViews()

    protected abstract fun initData()

    protected abstract fun initActions()

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
