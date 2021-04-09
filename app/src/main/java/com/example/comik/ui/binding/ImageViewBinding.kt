package com.example.comik.ui.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.comik.utils.loadImage
import com.example.comik.utils.loadImageCircle

@BindingAdapter("app:image", "app:cropStatus")
fun loadUrlImageCircle(imageView: ImageView, urlImage: String?, cropStatus: Boolean) {
    if (cropStatus) {
        imageView.loadImageCircle(urlImage)
    } else {
        imageView.loadImage(urlImage)
    }
}
