package warcraft.mounts.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup


interface ViewTypeDelegateAdapter{
    fun onCreateViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder

    // Connect a view type to a holder
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}