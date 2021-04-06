package com.example.comik.base

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseAdapter<T, VH : BaseViewHolder<T>>(
    diffUtil: DiffUtil.ItemCallback<T>
) : ListAdapter<T, VH>(diffUtil), UpdateDataAdapter<T> {

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bindData(getItem(position))
    }

    override fun setData(data: List<T>?) {
        submitList(data)
    }
}
