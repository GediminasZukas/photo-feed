package com.gapps.photofeed

import android.app.Application
import timber.log.Timber

class PhotoFeedApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initLogger()
    }

    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}