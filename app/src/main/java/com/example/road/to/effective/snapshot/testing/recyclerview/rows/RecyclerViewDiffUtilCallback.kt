package com.example.road.to.effective.snapshot.testing.recyclerview.rows

import androidx.recyclerview.widget.DiffUtil

class RecyclerViewDiffUtilCallback : DiffUtil.ItemCallback<RowType>() {

    data class Payload(val oldItem: RowType, val newItem: RowType)

    override fun areItemsTheSame(oldItem: RowType, newItem: RowType): Boolean {
        return oldItem.isTheSame(newItem)
    }

    override fun areContentsTheSame(
        oldItem: RowType,
        newItem: RowType
    ): Boolean =
        oldItem.isContentTheSame(newItem)

    override fun getChangePayload(oldItem: RowType, newItem: RowType): Any? {
        return oldItem.getChangePayLoad(newItem)
    }

}