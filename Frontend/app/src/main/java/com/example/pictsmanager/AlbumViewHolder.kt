package com.example.pictsmanager

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var albumNameView: TextView = itemView.findViewById<View>(R.id.textView_albumName) as TextView
    var albumDeleteView: CheckBox = itemView.findViewById<View>(R.id.checkBox_deleteAlbum) as CheckBox

}