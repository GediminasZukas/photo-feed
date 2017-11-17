package com.gapps.photofeed.screens.feed.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.gapps.photofeed.R
import com.gapps.photofeed.components.BaseViewHolder
import com.gapps.photofeed.components.LazyLoadingFeedAdapter
import com.gapps.photofeed.screens.feed.presentation.models.PhotoModel

@Suppress("UNCHECKED_CAST")
class PhotoListAdapter constructor(photosData: MutableList<PhotoModel?> = mutableListOf()) : LazyLoadingFeedAdapter<PhotoModel>(photosData as MutableList<Any?>) {

    companion object {
        const val TYPE_PHOTO = 1
    }

    override fun onViewHolderCreate(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): BaseViewHolder<PhotoModel> {
        return PhotoItemHolder(inflater.inflate(R.layout.item_photo, parent, false))
    }

    override fun getViewType(position: Int): Int {
        return TYPE_PHOTO
    }

    override fun onBindViewHolder(holder: BaseViewHolder<PhotoModel>, position: Int) {
        if (getItemViewType(position) == TYPE_PHOTO) {
            holder.binData(items[position] as PhotoModel)
        }
    }

    internal fun updateData(photosData: List<PhotoModel>) {
        items.addAll(photosData)
        notifyDataSetChanged()
    }
}