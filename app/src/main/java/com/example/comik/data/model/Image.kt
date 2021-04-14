package com.example.comik.data.model

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("path")
    var path: String
) {

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Image>() {
            override fun areItemsTheSame(oldItem: Image, newItem: Image) =
                oldItem.path == newItem.path

            override fun areContentsTheSame(oldItem: Image, newItem: Image) = oldItem == newItem
        }
    }
}
