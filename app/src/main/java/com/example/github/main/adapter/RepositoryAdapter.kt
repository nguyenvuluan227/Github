package com.example.github.main.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.base.adapter.BaseListAdapter
import com.example.base.adapter.DisplayableItem
import com.example.base.di.ActivityContext
import com.example.github.R
import javax.inject.Inject

class RepositoryAdapter @Inject constructor(@ActivityContext context: Context) :
    BaseListAdapter<DisplayableItem, RecyclerView.ViewHolder>(context) {

    companion object {
        const val ITEM_REPOSITORY = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_REPOSITORY -> {
                val itemView = inflater.inflate(R.layout.item_main, parent, false)
                RepositoryViewHolder(itemView)
            }
            else -> throw IllegalArgumentException("Do not support view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        return when (item.itemType) {
            ITEM_REPOSITORY -> {
                val repository = item as RepositoryItem
                val repositoryViewHolder = holder as RepositoryViewHolder
                repositoryViewHolder.onBind(repository)
            }
            else -> throw IllegalArgumentException("Do not support view type : ${item.itemType}")
        }
    }
}