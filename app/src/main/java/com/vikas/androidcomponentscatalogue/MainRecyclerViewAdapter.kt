package com.vikas.androidcomponentscatalogue

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainRecyclerViewAdapter(
    private val componentList: ArrayList<String>,
    private val recyclerViewOnClick: RecyclerViewOnClick
) : RecyclerView.Adapter<MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_recycler_view_item, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val component = componentList[position]
        holder.mainTitle.text = component
        holder.itemView.setOnClickListener {
            recyclerViewOnClick.onItemClick(component)
        }
    }

    override fun getItemCount() = componentList.size
}

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val mainTitle: TextView = itemView.findViewById(R.id.textView)
}