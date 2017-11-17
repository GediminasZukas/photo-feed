package com.gapps.photofeed.screens.feed.data.repository

import com.gapps.photofeed.network.ApiCallExecutor
import com.gapps.photofeed.screens.feed.data.sources.cloud.PhotosCloudDataStore
import javax.inject.Inject

class PhotosDataStoreFactory @Inject constructor(private val apiCallExecutor: ApiCallExecutor) {

    fun createCloudDataStore(param: Int): PhotosDataStore = PhotosCloudDataStore(apiCallExecutor, param)
}