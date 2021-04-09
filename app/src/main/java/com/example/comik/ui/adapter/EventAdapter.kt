package com.example.comik.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.comik.R
import com.example.comik.base.BaseAdapter
import com.example.comik.base.BaseViewHolder
import com.example.comik.data.model.Event
import com.example.comik.databinding.ItemEventBinding

class EventAdapter(
    private val onClickItem: (Event) -> Unit
) : BaseAdapter<Event, EventAdapter.EventViewHolder>(Event.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        EventViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_event, parent, false
            ),
            onClickItem
        )

    class EventViewHolder(
        private val itemEventBinding: ItemEventBinding,
        onClickItem: (Event) -> Unit
    ) : BaseViewHolder<Event>(itemEventBinding, onClickItem) {

        override fun bindData(item: Event) {
            super.bindData(item)
            itemEventBinding.event = item
        }
    }
}
