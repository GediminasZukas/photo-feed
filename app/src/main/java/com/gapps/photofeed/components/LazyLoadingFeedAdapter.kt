package com.gapps.photofeed.components

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gapps.photofeed.R

abstract class LazyLoadingFeedAdapter<anyType : Any>(protected val items: MutableList<Any?>) : RecyclerView.Adapter<BaseViewHolder<anyType>>() {

    companion object {
        const val LOAD_MORE_ITEMS = 111
    }

    protected abstract fun getViewType(position: Int): Int

    protected abstract fun onViewHolderCreate(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): BaseViewHolder<anyType>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<anyType> {
        val inflater = LayoutInflater.from(parent.context)
        when (viewType) {
            LOAD_MORE_ITEMS -> return NoDataViewHolder(inflater.inflate(R.layout.item_load_more, parent, false))
        }

        return onViewHolderCreate(inflater, parent, viewType)
    }

    override fun getItemViewType(position: Int): Int {
        if (items[position] == null) {
            return LOAD_MORE_ITEMS
        }

        return getViewType(position)
    }

    internal fun showLoadingView() {
        items.add(null)
        notifyItemInserted(items.size - 1)
    }

    internal fun hideLoadingView() {
        items.remove(null)
        notifyItemRemoved(items.size)
    }

    override fun getItemCount(): Int = items.size
}