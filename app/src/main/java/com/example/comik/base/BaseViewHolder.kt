package com.example.comik.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(
    binding: ViewDataBinding,
    click: (T) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private var itemData: T? = null

    init {
        binding.root.setOnClickListener {
            itemData?.let {
                click(it)
            }
        }
    }

    open fun bindData(item: T) {
        itemData = item
    }
}
