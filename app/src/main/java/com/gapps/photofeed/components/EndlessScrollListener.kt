package com.gapps.photofeed.components

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

abstract class EndlessScrollListener(private val layoutManager: LinearLayoutManager,
                                     private val amountLoadIndicators: Int = 1) : RecyclerView.OnScrollListener() {

    companion object {
        private const val LOADING_THRESHOLD = 5
    }

    private var currentPage = 0
    private var totalItemCount = 0
    private var totalItemCountInPreviousPage = 0
    private var lastVisibleItem = 0
    private var isAlreadyLoading = false

    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        totalItemCount = layoutManager.itemCount
        lastVisibleItem = layoutManager.findLastVisibleItemPosition()

        if (isAlreadyLoading && isTotalItemCountJustUpdated()) {
            isAlreadyLoading = false
        }

        checkIfNeedToLoadNextPage()
    }

    private fun isTotalItemCountJustUpdated(): Boolean {
        return totalItemCount > totalItemCountInPreviousPage + amountLoadIndicators
    }

    private fun checkIfNeedToLoadNextPage() {
        if (!isAlreadyLoading && totalItemCount <= (lastVisibleItem + LOADING_THRESHOLD)) {
            isAlreadyLoading = true
            totalItemCountInPreviousPage = totalItemCount
            currentPage++
            onLoadMoreData(currentPage)
        }
    }

    abstract fun onLoadMoreData(nextPage: Int)
}