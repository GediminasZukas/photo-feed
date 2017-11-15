package com.gapps.photofeed.screens.feed.data.repository

import com.gapps.photofeed.screens.feed.domain.models.Photos
import io.reactivex.Observable

interface PhotosDataStore {
    fun recentPhotoList(): Observable<Photos>
}