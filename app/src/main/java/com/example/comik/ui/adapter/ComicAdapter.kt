package com.example.comik.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.comik.R
import com.example.comik.base.BaseAdapter
import com.example.comik.base.BaseViewHolder
import com.example.comik.data.model.Comic
import com.example.comik.databinding.ItemComicBinding

class ComicAdapter(
    private val onClickItem: (Comic) -> Unit
) : BaseAdapter<Comic, ComicAdapter.ComicViewHolder>(Comic.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ComicViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_comic, parent, false
            ),
            onClickItem
        )

    class ComicViewHolder(
        private val itemComicBinding: ItemComicBinding,
        onClickItem: (Comic) -> Unit
    ) : BaseViewHolder<Comic>(itemComicBinding, onClickItem) {

        override fun bindData(item: Comic) {
            super.bindData(item)
            itemComicBinding.comic = item
        }
    }
}
