package com.gapps.photofeed.screens.feed.presentation.view

import android.view.View
import com.gapps.photofeed.components.BaseViewHolder
import com.gapps.photofeed.components.ImageLoader
import com.gapps.photofeed.screens.feed.presentation.models.PhotoModel
import kotlinx.android.synthetic.main.item_photo.view.*

class PhotoItemHolder constructor(private val view: View) : BaseViewHolder<PhotoModel>(view) {

    private val imagePhoto = view.imagePhoto
    private val imageAuthorPhoto = view.imageAuthorPhoto
    private val textAuthorName = view.textAuthorName
    private val textPhotoTitle = view.textPhotoTitle

    override fun binData(data: PhotoModel) {
        val context = view.context
        ImageLoader.loadImage(context, data.photoUrl, imagePhoto)
        ImageLoader.loadImage(context, data.authorAvatarUrl, imageAuthorPhoto)
        textAuthorName.text = data.authorName
        textPhotoTitle.text = data.photoTitle
    }
}