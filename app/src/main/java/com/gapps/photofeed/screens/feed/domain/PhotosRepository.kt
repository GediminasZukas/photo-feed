package com.gapps.photofeed.screens.feed.domain

import com.gapps.photofeed.screens.feed.domain.models.Photos
import io.reactivex.Observable

interface PhotosRepository {

    fun getPhotos(param: Int): Observable<Photos>
}