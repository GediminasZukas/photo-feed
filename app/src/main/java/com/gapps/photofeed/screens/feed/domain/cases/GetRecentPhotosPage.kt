package com.gapps.photofeed.screens.feed.domain.cases

import com.gapps.photofeed.components.UseCase
import com.gapps.photofeed.screens.feed.domain.PhotosRepository
import com.gapps.photofeed.screens.feed.domain.models.Photos
import io.reactivex.Observable
import javax.inject.Inject

class GetRecentPhotosPage @Inject constructor(private val photosRepository: PhotosRepository) : UseCase<Photos, Int>() {

    override fun buildUseCaseObservable(params: Int): Observable<Photos> =
            photosRepository.getPhotos(params)
}