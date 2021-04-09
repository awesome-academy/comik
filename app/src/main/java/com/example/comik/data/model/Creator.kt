package com.example.comik.data.model

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class Creator(
    @SerializedName("id")
    val id: Int,
    @SerializedName("fullName")
    val fullName: String,
    @SerializedName("modified")
    val modified: String,
    @SerializedName("thumbnail")
    val thumbnail: Image
) {

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Creator>() {
            override fun areItemsTheSame(oldItem: Creator, newItem: Creator) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Creator, newItem: Creator) = oldItem == newItem
        }
    }
}
