package com.example.pictsmanager

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

internal class CustomRecyclerViewAdapter2(
    private val context: Context,
    private val pictures: List<Picture>
) : RecyclerView.Adapter<PictureViewHolder>() {
    private val mLayoutInflater: LayoutInflater
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        val recyclerViewItem = mLayoutInflater.inflate(R.layout.picture_item, parent, false)
        recyclerViewItem.setOnClickListener { v ->
            handleRecyclerItemClick(
                parent as RecyclerView,
                v
            )
        }
        return PictureViewHolder(recyclerViewItem)
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        // Cet country in countries via position
        val picture = pictures[position]
        holder.pictureNameView.text = picture.namePicture
    }

    override fun getItemCount(): Int {
        return pictures.size
    }

    private fun handleRecyclerItemClick(recyclerView: RecyclerView, itemView: View) {
        val itemPosition = recyclerView.getChildLayoutPosition(itemView)
        val picture = pictures[itemPosition]
        Toast.makeText(context, picture.namePicture, Toast.LENGTH_LONG).show()
    }

    init {
        mLayoutInflater = LayoutInflater.from(context)
    }
}