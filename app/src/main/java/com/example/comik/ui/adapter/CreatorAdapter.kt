package com.example.comik.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.comik.R
import com.example.comik.base.BaseAdapter
import com.example.comik.base.BaseViewHolder
import com.example.comik.data.model.Creator
import com.example.comik.databinding.ItemCreatorBinding

class CreatorAdapter(
    private val onClickItem: (Creator) -> Unit
) : BaseAdapter<Creator, CreatorAdapter.CreatorViewHolder>(Creator.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CreatorViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_creator, parent, false
            ),
            onClickItem
        )

    class CreatorViewHolder(
        private val itemCreatorBinding: ItemCreatorBinding,
        onClickItem: (Creator) -> Unit
    ) : BaseViewHolder<Creator>(itemCreatorBinding, onClickItem) {

        override fun bindData(item: Creator) {
            super.bindData(item)
            itemCreatorBinding.creator = item
        }
    }
}
