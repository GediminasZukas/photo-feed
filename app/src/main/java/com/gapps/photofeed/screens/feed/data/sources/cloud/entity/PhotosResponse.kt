package com.gapps.photofeed.screens.feed.data.sources.cloud.entity

import com.squareup.moshi.Json

data class PhotosResponse constructor(@Json(name = "photos") val photosEntity: PhotosEntity)