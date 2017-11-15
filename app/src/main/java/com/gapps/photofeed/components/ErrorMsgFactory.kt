package com.gapps.photofeed.components

import android.content.Context
import com.gapps.photofeed.R
import com.gapps.photofeed.network.NoNetworkConnectionException

class ErrorMsgFactory {
    companion object {
        fun getErrorMsg(error: Throwable, context: Context): String {
            when (error) {
                is NoNetworkConnectionException -> return context.getString(R.string.errorNetwork)
            }

            return context.getString(R.string.errorUnknown)
        }
    }
}