package com.example.comik.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.comik.R
import com.example.comik.base.BaseAdapter
import com.example.comik.base.BaseViewHolder
import com.example.comik.data.model.Comic
import com.example.comik.databinding.ItemBannerBinding

class BannerAdapter(
    private val onClickItem: (Comic) -> Unit
) : BaseAdapter<Comic, BannerAdapter.BannerViewHolder>(Comic.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BannerViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_banner, parent, false
            ),
            onClickItem
        )

    class BannerViewHolder(
        private val itemBannerBinding: ItemBannerBinding,
        onClickItem: (Comic) -> Unit
    ) : BaseViewHolder<Comic>(itemBannerBinding, onClickItem) {

        override fun bindData(item: Comic) {
            super.bindData(item)
            itemBannerBinding.banner = item
        }
    }
}
