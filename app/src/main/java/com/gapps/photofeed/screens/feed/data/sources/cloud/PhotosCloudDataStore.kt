package com.gapps.photofeed.screens.feed.data.sources.cloud

import android.text.TextUtils
import com.gapps.photofeed.network.ApiCallExecutor
import com.gapps.photofeed.screens.feed.data.repository.PhotosDataStore
import com.gapps.photofeed.screens.feed.data.sources.cloud.entity.PhotosResponse
import com.gapps.photofeed.screens.feed.domain.models.Photos
import io.reactivex.Observable

class PhotosCloudDataStore (private val apiCallExecutor: ApiCallExecutor, private val pageNumber: Int) : PhotosDataStore {

    companion object {
        const val API_METHOD = "method"
        const val ITEMS_PER_PAGE = "per_page"
        const val PAGE_NUMBER = "page"
        const val API_EXTRA_PARAMS = "extras"
        const val METHOD_RECENT_PHOTOS = "flickr.photos.getRecent"
        const val RECENT_PHOTOS_PER_PAGE = "40"
        const val EXTRA_240_IMAGE = "url_m"
        const val EXTRA_320_IMAGE = "url_n"
        const val EXTRA_640_IMAGE = "url_z"
        const val EXTRA_OWNER_NAME = "owner_name"
        const val EXTRA_OWNER_AVATAR = "icon_server"
    }

    override fun recentPhotoList(): Observable<Photos> {
        return apiCallExecutor.getRecentPhotosPage(getRecentPhotoListParams())
                .map { response -> formatRecentPhotosResponse(response) }
    }

    private fun getRecentPhotoListParams(): HashMap<String, String> {
        val params = HashMap<String, String>()
        params.put(API_METHOD, METHOD_RECENT_PHOTOS)
        params.put(PAGE_NUMBER, pageNumber.toString())
        params.put(ITEMS_PER_PAGE, RECENT_PHOTOS_PER_PAGE)
        params.put(API_EXTRA_PARAMS, TextUtils.join(",", arrayOf(EXTRA_240_IMAGE,
                EXTRA_320_IMAGE, EXTRA_640_IMAGE, EXTRA_OWNER_NAME, EXTRA_OWNER_AVATAR)))
        return params
    }

    private fun formatRecentPhotosResponse(response: PhotosResponse): Photos {
        return PhotosEntityDataMapper().mapPhotosResponseEntity(response)
    }
}