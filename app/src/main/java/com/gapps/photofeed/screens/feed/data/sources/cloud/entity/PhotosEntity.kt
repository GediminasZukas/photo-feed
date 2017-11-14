package com.gapps.photofeed.screens.feed.data.sources.cloud.entity

import com.squareup.moshi.Json

data class PhotosEntity constructor(@Json(name = "photo") val photoList: List<PhotoEntity>)