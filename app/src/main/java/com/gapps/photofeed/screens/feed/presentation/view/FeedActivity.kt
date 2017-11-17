package com.gapps.photofeed.screens.feed.presentation.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.gapps.photofeed.R
import com.gapps.photofeed.components.EndlessScrollListener
import com.gapps.photofeed.components.ErrorMsgFactory
import com.gapps.photofeed.screens.feed.presentation.FeedScreenPresenter
import com.gapps.photofeed.screens.feed.presentation.models.PhotoModel
import com.gapps.photofeed.screens.feed.presentation.models.PhotosModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_feed.*
import timber.log.Timber
import javax.inject.Inject

class FeedActivity : AppCompatActivity(), FeedScreen {

    companion object {
        const val FIRST_PAGE = 0
    }

    @Inject lateinit var feedPresenter: FeedScreenPresenter
    @Inject lateinit var adapter: PhotoListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)
        feedPresenter.setView(this)

        initLazyListLoading()
        getPageOfRecentPhotos(FIRST_PAGE)
    }

    private fun getPageOfRecentPhotos(pageNumber: Int) {
        feedPresenter.getPageOfRecentPhotos(pageNumber)
    }

    override fun onRecentPhotosPageReceive(photosModel: PhotosModel) {
        updatePhotoList(photosModel.photosData)
    }

    private fun updatePhotoList(photosData: List<PhotoModel>) {
        if (listPhotoFeed.adapter == null) {
            listPhotoFeed.adapter = adapter
        } else {
            adapter.hideLoadingView()
        }

        adapter.updateData(photosData)
    }

    private fun initLazyListLoading() {
        listPhotoFeed.addOnScrollListener(object : EndlessScrollListener(listPhotoFeed.layoutManager as LinearLayoutManager) {
            override fun onLoadMoreData(nextPage: Int) {
                getPageOfRecentPhotos(nextPage)
                adapter.showLoadingView()
            }
        })
    }

    }

    override fun onDataError(error: Throwable) {
        adapter.hideLoadingView()
        Timber.e(error)
        Toast.makeText(baseContext, ErrorMsgFactory.getErrorMsg(error, baseContext), Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        feedPresenter.onDestroy()
        super.onDestroy()
    }
}