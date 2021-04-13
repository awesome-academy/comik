package com.example.comik.ui.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.comik.base.UpdateDataAdapter
import com.example.comik.utils.BUNDLE.BUNDLE_CHARACTER
import com.example.comik.utils.BUNDLE.BUNDLE_CREATOR
import com.example.comik.utils.BUNDLE.BUNDLE_EVENT
import com.example.comik.utils.BUNDLE.BUNDLE_SERIES
import com.example.comik.utils.BUNDLE.BUNDLE_STORY

@BindingAdapter("app:data")
fun <T> setDataRecyclerView(recyclerView: RecyclerView, data: List<T>?) {
    (recyclerView.adapter as UpdateDataAdapter<T>).setData(data)
}

@BindingAdapter(
    "app:type",
    "app:series",
    "app:creators",
    "app:stories",
    "app:events",
    "app:characters"
)
fun <T> setDataByType(
    recyclerView: RecyclerView,
    type: String?,
    series: List<T>?,
    creators: List<T>?,
    stories: List<T>?,
    events: List<T>?,
    characters: List<T>?
) {
    when (type) {
        BUNDLE_STORY -> setDataRecyclerView(recyclerView, stories)
        BUNDLE_CHARACTER -> setDataRecyclerView(recyclerView, characters)
        BUNDLE_SERIES -> setDataRecyclerView(recyclerView, series)
        BUNDLE_EVENT -> setDataRecyclerView(recyclerView, events)
        BUNDLE_CREATOR -> setDataRecyclerView(recyclerView, creators)
    }
}
