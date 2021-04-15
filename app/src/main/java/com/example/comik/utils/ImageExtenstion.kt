package com.example.comik.utils

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.example.comik.R
import com.example.comik.utils.BaseUrlImage.baseUrlImage

fun ImageView.loadImage(image: String?) {
    Glide.with(context).load(image?.let { baseUrlImage(it) })
        .error(R.drawable.ic_error)
        .placeholder(R.drawable.ic_place_holder)
        .into(this)
}

fun ImageView.loadImageCircle(image: String?) {
    Glide.with(context).load(image?.let { baseUrlImage(it) })
        .error(R.drawable.ic_error)
        .placeholder(R.drawable.ic_place_holder)
        .circleCrop()
        .into(this)
}

fun ImageView.loadLocalImageCircle(@DrawableRes image: Int) {
    Glide.with(context).load(image).circleCrop().into(this)
}
