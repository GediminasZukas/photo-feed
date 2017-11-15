package com.gapps.photofeed.network

import com.gapps.photofeed.BuildConfig
import com.gapps.photofeed.screens.feed.data.sources.cloud.RecentPhotosApiCall
import com.gapps.photofeed.screens.feed.data.sources.cloud.entity.PhotosResponse
import io.reactivex.Observable
import retrofit2.Retrofit

class ApiCallExecutor constructor(private val restClient: Retrofit) {

    private val basicRequestParams: HashMap<String, String> = HashMap()

    companion object {
        const val KEY_API_KEY = "api_key"
        const val KEY_API_RESPONSE_FORMAT = "format"
        const val KEY_API_IS_RAW_JSON_RESPONSE = "nojsoncallback"

        const val VALUE_API_RESPONSE_FORMAT = "json"
        const val VALUE_API_IS_RAW_JSON_RESPONSE = "1"
    }

    init {
        basicRequestParams.put(KEY_API_KEY, BuildConfig.FLICKR_API_KEY)
        basicRequestParams.put(KEY_API_RESPONSE_FORMAT, VALUE_API_RESPONSE_FORMAT)
        basicRequestParams.put(KEY_API_IS_RAW_JSON_RESPONSE, VALUE_API_IS_RAW_JSON_RESPONSE)
    }

    private fun getFullRequestParams(params: HashMap<String, String>): HashMap<String, String> {
        params.putAll(basicRequestParams)
        return params
    }

    fun getRecentPhotosPage(params: HashMap<String, String>): Observable<PhotosResponse> {
        val recentPhotosAPiCall = restClient.create(RecentPhotosApiCall::class.java)
        return recentPhotosAPiCall.connect(getFullRequestParams(params))
    }
}