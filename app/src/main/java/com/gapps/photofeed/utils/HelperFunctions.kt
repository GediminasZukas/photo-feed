package com.gapps.photofeed.utils

import android.content.Context
import android.net.ConnectivityManager

fun hasNetworkConnection(applicationContext: Context): Boolean {
    val cm = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = cm.activeNetworkInfo
    return activeNetwork != null && activeNetwork.isConnectedOrConnecting
}