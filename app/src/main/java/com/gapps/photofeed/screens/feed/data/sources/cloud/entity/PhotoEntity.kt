package com.gapps.photofeed.screens.feed.data.sources.cloud.entity

import com.squareup.moshi.Json

data class PhotoEntity constructor(@Json(name = "id") val id: Long,
                                   @Json(name = "title") val title: String,
                                   @Json(name = "url_m") val urlImage240: String?,
                                   @Json(name = "url_n") val urlImage320: String?,
                                   @Json(name = "url_z") val urlImage640: String?,
                                   @Json(name = "ownername") val ownerName: String,
                                   @Json(name = "owner") val ownerId: String,
                                   @Json(name = "iconserver") val iconServer: Long,
                                   @Json(name = "iconfarm") val iconFarm: Long)