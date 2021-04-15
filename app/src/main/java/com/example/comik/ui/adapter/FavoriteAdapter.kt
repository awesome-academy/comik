package com.example.comik.ui.adapter

import android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.comik.R
import com.example.comik.base.BaseAdapter
import com.example.comik.base.BaseViewHolder
import com.example.comik.data.model.Comic
import com.example.comik.databinding.ItemComicFavoriteBinding

class FavoriteAdapter(
    private val onClickItem: (Comic) -> Unit
) : BaseAdapter<Comic, FavoriteAdapter.FavoriteViewHolder>(Comic.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FavoriteViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_comic_favorite, parent, false
            ),
            onClickItem
        )

    class FavoriteViewHolder(
        private val itemComicFavoriteBinding: ItemComicFavoriteBinding,
        onClickItem: (Comic) -> Unit
    ) : BaseViewHolder<Comic>(itemComicFavoriteBinding, onClickItem) {

        override fun bindData(item: Comic) {
            super.bindData(item)
            itemComicFavoriteBinding.comic = item
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                itemComicFavoriteBinding.textDescription.justificationMode =
                    JUSTIFICATION_MODE_INTER_WORD
            }
        }
    }
}
