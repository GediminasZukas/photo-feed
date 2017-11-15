package com.gapps.photofeed.screens.feed.data.sources.cloud

import com.gapps.photofeed.screens.feed.data.sources.cloud.entity.PhotosResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface RecentPhotosApiCall {
    @GET("rest/")
    fun connect(@QueryMap requestParams: Map<String, String>): Observable<PhotosResponse>
}