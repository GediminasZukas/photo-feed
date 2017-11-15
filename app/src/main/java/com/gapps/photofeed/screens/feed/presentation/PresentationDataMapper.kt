package com.gapps.photofeed.screens.feed.presentation

import com.gapps.photofeed.screens.feed.domain.models.Photos
import com.gapps.photofeed.screens.feed.presentation.models.PhotoModel
import com.gapps.photofeed.screens.feed.presentation.models.PhotosModel

class PresentationDataMapper private constructor() {

    companion object {
        fun transform(photos: Photos): PhotosModel {
            val photosModelData: MutableList<PhotoModel> = mutableListOf()
            photos.photosData.map {
                photosModelData.add(PhotoModel(it.photoUrl, it.photoTitle,
                        it.authorAvatarUrl, it.authorName))
            }
            return PhotosModel(photosModelData)
        }
    }
}