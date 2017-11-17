package com.gapps.photofeed.di.modules

import com.gapps.photofeed.components.Presenter
import com.gapps.photofeed.components.UseCase
import com.gapps.photofeed.network.ApiCallExecutor
import com.gapps.photofeed.screens.feed.data.repository.PhotosDataRepository
import com.gapps.photofeed.screens.feed.data.repository.PhotosDataStoreFactory
import com.gapps.photofeed.screens.feed.domain.PhotosRepository
import com.gapps.photofeed.screens.feed.domain.cases.GetRecentPhotosPage
import com.gapps.photofeed.screens.feed.domain.models.Photos
import com.gapps.photofeed.screens.feed.presentation.FeedScreenPresenter
import com.gapps.photofeed.screens.feed.presentation.view.PhotoListAdapter
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class FeedScreenModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun providePhotosDataStoreFactory(apiCallExecutor: ApiCallExecutor): PhotosDataStoreFactory
                = PhotosDataStoreFactory(apiCallExecutor)

        @JvmStatic
        @Provides
        fun providePhotoListAdapter(): PhotoListAdapter = PhotoListAdapter()
    }

    @Binds
    abstract fun providePhotosRepository(photosDataRepository: PhotosDataRepository): PhotosRepository

    @Binds
    abstract fun provideGetRecentPhotosPage(getRecentPhotosPage: GetRecentPhotosPage): UseCase<Photos, Int>

    @Binds
    abstract fun provideFeedScreenPresenter(feedScreenPresenter: FeedScreenPresenter): Presenter
}