package com.example.pictsmanager

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var albumNameView: TextView

    init {
        albumNameView = itemView.findViewById<View>(R.id.textView_albumName) as TextView
    }
}