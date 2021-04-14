package com.example.comik.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.comik.R
import com.example.comik.base.BaseAdapter
import com.example.comik.base.BaseViewHolder
import com.example.comik.data.model.Image
import com.example.comik.databinding.ItemPosterBinding

class PosterAdapter : BaseAdapter<Image, PosterAdapter.PosterViewHolder>(Image.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PosterViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_poster, parent, false
            )
        )

    class PosterViewHolder(
        private val itemPosterBinding: ItemPosterBinding
    ) : BaseViewHolder<Image>(itemPosterBinding, {}) {

        override fun bindData(item: Image) {
            super.bindData(item)
            itemPosterBinding.image = item
        }
    }
}
