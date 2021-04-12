package com.example.comik.ui.binding

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("app:visible")
fun goneUnless(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}
