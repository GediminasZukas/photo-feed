package com.gapps.photofeed.screens.feed.presentation.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.gapps.photofeed.R
import com.gapps.photofeed.components.ErrorMsgFactory
import com.gapps.photofeed.screens.feed.presentation.FeedScreenPresenter
import com.gapps.photofeed.screens.feed.presentation.models.PhotosModel
import timber.log.Timber
import javax.inject.Inject

class FeedActivity : AppCompatActivity(), FeedScreen {

    @Inject lateinit var feedPresenter: FeedScreenPresenter
    private var photosPageNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)
        feedPresenter.setView(this)

        getPageOfRecentPhotos()
    }

    private fun getPageOfRecentPhotos() {
        feedPresenter.getPageOfRecentPhotos(photosPageNumber)
    }

    override fun onDestroy() {
        feedPresenter.onDestroy()
        super.onDestroy()
    }

    override fun onRecentPhotosPageReceive(photosModel: PhotosModel) {
        Toast.makeText(baseContext, "photos received", Toast.LENGTH_SHORT).show()
    }

    override fun onDataError(error: Throwable) {
        Timber.e(error)
        Toast.makeText(baseContext, ErrorMsgFactory.getErrorMsg(error, baseContext), Toast.LENGTH_SHORT).show()
    }
}