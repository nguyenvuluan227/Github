package com.example.github.main.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.base.adapter.DisplayableItem
import com.example.domain.model.Repository
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_main.view.*

class RepositoryItem(val repository: Repository) : DisplayableItem {
    override val itemType: Int
        get() = RepositoryAdapter.ITEM_REPOSITORY

    override fun getKey(): String {
        return ""
    }
}

class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun onBind(item: RepositoryItem) {
        itemView.tvTitle.text = "Name: ${item.repository.name}"
        itemView.tvID.text = "ID: ${item.repository.id}"
        Picasso.get().load(item.repository.owner.avatarUrl).into(itemView.imvAvatar)
    }
}