package com.gapps.photofeed.screens.feed.data.repository

import com.gapps.photofeed.screens.feed.domain.PhotosRepository
import com.gapps.photofeed.screens.feed.domain.models.Photos
import io.reactivex.Observable
import javax.inject.Inject

class PhotosDataRepository @Inject constructor(private val photosDataStoreFactory: PhotosDataStoreFactory) : PhotosRepository {

    override fun getPhotos(param: Int): Observable<Photos> {
        val dataStore = photosDataStoreFactory.createCloudDataStore()
        return dataStore.recentPhotoList()
    }
}