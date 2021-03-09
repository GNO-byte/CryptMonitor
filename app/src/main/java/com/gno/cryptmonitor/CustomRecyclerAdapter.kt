package com.gno.cryptmonitor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gno.cryptmonitor.retrofit.Data

class CustomRecyclerAdapter(private val values: List<Data>,
                            private val cellClickListener: CellClickListener) :
    RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameTextView?.text = values[position].name
        holder.nameTextView?.setOnClickListener {
            cellClickListener.onCellClickListener(position)
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameTextView: TextView? = null

        init {
            nameTextView = itemView?.findViewById(R.id.recyclerview_item_name)

        }
    }

    interface CellClickListener {
        fun onCellClickListener(index: Int)
    }
}