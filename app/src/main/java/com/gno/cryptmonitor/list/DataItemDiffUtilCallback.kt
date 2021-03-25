package com.gno.cryptmonitor.list

import androidx.recyclerview.widget.DiffUtil
import com.gno.cryptmonitor.retrofit.Data

class DataItemDiffUtilCallback : DiffUtil.ItemCallback<Data>() {

    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean =
        oldItem.name == newItem.name

}