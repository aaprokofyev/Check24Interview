package de.check24.devtest.ui

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


object BindingAdapters {

    @JvmStatic
    @BindingAdapter("photoUrl", "placeholder")
    fun loadProductImage(view: ImageView, imageUrl: String?, placeholder: Drawable) {
        Glide.with(view.context).load(imageUrl)
            .centerCrop()
            .placeholder(placeholder)
            .into(view)
    }
}