package com.gapps.photofeed.screens.feed.domain.cases

import com.gapps.photofeed.components.UseCase
import com.gapps.photofeed.screens.feed.domain.PhotosRepository
import com.gapps.photofeed.screens.feed.domain.models.Photo
import com.gapps.photofeed.screens.feed.domain.models.Photos
import io.reactivex.Observable
import javax.inject.Inject

class GetRecentPhotosPage @Inject constructor(private val photosRepository: PhotosRepository) : UseCase<Photos, Int>() {

    companion object {
        private const val AUTHOR_NAME_PREFIX = "by "
    }

    override fun buildUseCaseObservable(params: Int): Observable<Photos> {
        return photosRepository.getPhotos(params).map { photos -> addPrefixToAuthorName(photos) }
    }

    private fun addPrefixToAuthorName(photos: Photos): Photos {
        val modifiedPhotoList = mutableListOf<Photo>()

        photos.photosData.forEach {
            it.authorName = AUTHOR_NAME_PREFIX.plus(it.authorName)
            modifiedPhotoList.add(it.copy())
        }

        return Photos(modifiedPhotoList)
    }
}