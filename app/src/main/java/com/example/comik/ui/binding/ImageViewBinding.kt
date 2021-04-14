package com.example.comik.ui.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.comik.utils.loadImage
import com.example.comik.utils.loadImageCircle

@BindingAdapter("app:image", "app:cropStatus" , requireAll = false)
fun loadUrlImageCircle(imageView: ImageView, urlImage: String?, cropStatus: Boolean =false) {
    if (cropStatus) {
        imageView.loadImageCircle(urlImage)
    } else {
        imageView.loadImage(urlImage)
    }
}
