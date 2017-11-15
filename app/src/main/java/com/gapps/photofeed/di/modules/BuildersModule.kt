package com.gapps.photofeed.di.modules

import com.gapps.photofeed.screens.feed.presentation.view.FeedActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = arrayOf(FeedScreenModule::class))
    abstract fun bindFeedActivity(): FeedActivity
}