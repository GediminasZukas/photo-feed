package com.gapps.photofeed.screens.feed.data.sources.cloud

import com.gapps.photofeed.screens.feed.data.sources.cloud.entity.PhotoEntity
import com.gapps.photofeed.screens.feed.data.sources.cloud.entity.PhotosResponse
import com.gapps.photofeed.screens.feed.domain.models.Photo
import com.gapps.photofeed.screens.feed.domain.models.Photos

class PhotosEntityDataMapper {

    companion object {
        const val EMPTY_AVATAR_URL = "https://www.flickr.com/images/buddyicon.jpg"
    }

    fun mapPhotosResponseEntity(response: PhotosResponse): Photos {
        val filteredResponsePhotos: List<PhotoEntity> = filterOutPhotosWithNullUrl(response.photosEntity.photoList)
        val mappedPhotoList: MutableList<Photo> = mutableListOf()

        filteredResponsePhotos.map {
            mappedPhotoList.add(Photo(getPhotoUrl(it), it.title,
                    getPhotoAuthorAvatar(it), it.ownerName))
        }

        return Photos(mappedPhotoList)
    }

    private fun filterOutPhotosWithNullUrl(photos: List<PhotoEntity>): List<PhotoEntity> {
        return photos.filter {
            it.urlImage240 != null || it.urlImage320 != null || it.urlImage640 != null
        }
    }

    private fun getPhotoUrl(photo: PhotoEntity): String {
        photo.urlImage240?.let { return it }
        photo.urlImage320?.let { return it }
        return photo.urlImage640 as String
    }

    private fun getPhotoAuthorAvatar(photo: PhotoEntity): String {
        val iconServerId = photo.iconServer
        return if (iconServerId > 0) {
            "http://farm${photo.iconFarm}.staticflickr.com/$iconServerId/buddyicons/${photo.ownerId}.jpg"
        } else {
            EMPTY_AVATAR_URL
        }
    }
}