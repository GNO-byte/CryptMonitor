package com.gno.cryptmonitor.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gno.cryptmonitor.R
import com.gno.cryptmonitor.retrofit.Data

//class CustomRecyclerAdapter(
//    private val values: List<Data>,
//    private val cellClickListener: (Int) -> Unit
//) :

class CustomRecyclerAdapter(
    private val cellClickListener: (Int) -> Unit
) : ListAdapter<Data, CustomRecyclerAdapter.DataHolder>(DataItemDiffUtilCallback()) {

    override fun getItemCount(): Int {
        return when (val count = super.getItemCount()) {
            0 -> 0
            else -> count
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        return DataHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {

        holder.nameTextView?.text = getItem(position).name
        holder.nameTextView?.setOnClickListener {
            cellClickListener.invoke(position)
        }

    }

    class DataHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameTextView: TextView? = null

        init {
            nameTextView = itemView.findViewById(R.id.recyclerview_item_name)
        }
    }

}