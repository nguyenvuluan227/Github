package com.example.base.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class PaddingItemDecoration(private val topBottom: Int, private val leftRight: Int = 0) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(leftRight, topBottom, leftRight, topBottom)
    }
}