package com.gapps.photofeed.screens.feed.presentation.view

import com.gapps.photofeed.screens.feed.presentation.models.PhotosModel

interface FeedScreen {
    fun onRecentPhotosPageReceive(photosModel: PhotosModel)
    fun onDataError(error: Throwable)
}