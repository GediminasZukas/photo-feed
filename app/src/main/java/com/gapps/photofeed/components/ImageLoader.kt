package com.gapps.photofeed.components

import android.content.Context
import android.widget.ImageView
import com.squareup.picasso.Picasso

class ImageLoader private constructor() {
    companion object {
        fun loadImage(context: Context, uri: String, imageView: ImageView) {
            Picasso.with(context).load(uri).into(imageView)
        }
    }
}