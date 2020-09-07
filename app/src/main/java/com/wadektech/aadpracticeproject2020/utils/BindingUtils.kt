package com.wadektech.aadpracticeproject2020.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("badgeImage")
fun bindBadgeImages(imageView: AppCompatImageView, imageUrl: String?){
    imageUrl?.let {
        val imageUri = imageUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context)
            .load(imageUri)
            .into(imageView)
    }
}