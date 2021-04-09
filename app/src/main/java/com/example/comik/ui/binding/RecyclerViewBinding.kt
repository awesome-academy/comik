package com.example.comik.ui.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.comik.base.UpdateDataAdapter

@BindingAdapter("app:data")
fun <T> setDataRecyclerView(recyclerView: RecyclerView, data: List<T>?) {
    (recyclerView.adapter as UpdateDataAdapter<T>).setData(data)
}
