package com.gapps.photofeed.components

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder<in T> constructor(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun binData(data: T)
}