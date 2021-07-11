package com.example.pictsmanager

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PictureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var pictureNameView: TextView = itemView.findViewById<View>(R.id.textView_pictureName) as TextView
    var pictureView: ImageView = itemView.findViewById<View>(R.id.imageView_picture) as ImageView
}