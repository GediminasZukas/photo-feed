package com.gapps.photofeed.screens.feed.presentation

import com.gapps.photofeed.components.CustomObserver
import com.gapps.photofeed.components.Presenter
import com.gapps.photofeed.screens.feed.domain.cases.GetRecentPhotosPage
import com.gapps.photofeed.screens.feed.domain.models.Photos
import com.gapps.photofeed.screens.feed.presentation.view.FeedScreen
import javax.inject.Inject

class FeedScreenPresenter @Inject constructor(private val getRecentPhotosPage: GetRecentPhotosPage) : Presenter {

    lateinit var feedScreen: FeedScreen

    fun setView(feedScreen: FeedScreen) {
        this.feedScreen = feedScreen
    }

    fun getPageOfRecentPhotos(photosPageNumber: Int) {
        getRecentPhotosPage.execute(RecentPhotosObserver(), photosPageNumber)
    }

    override fun onDestroy() {
        getRecentPhotosPage.dispose()
    }

    fun presentRecentPhotos(photos: Photos) {
        feedScreen.onRecentPhotosPageReceive(PresentationDataMapper.transform(photos))
    }

    private inner class RecentPhotosObserver : CustomObserver<Photos>() {
        override fun onNext(data: Photos) {
            presentRecentPhotos(data)
        }

        override fun onError(exception: Throwable) {
            feedScreen.onDataError(exception)
        }
    }
}