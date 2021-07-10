package com.example.pictsmanager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

internal class CustomRecyclerViewAdapter(
    private val context: Context,
    private val albums: List<Album>
) : RecyclerView.Adapter<AlbumViewHolder>() {
    private val mLayoutInflater: LayoutInflater
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val recyclerViewItem = mLayoutInflater.inflate(R.layout.album_item, parent, false)
        recyclerViewItem.setOnClickListener { v ->
            handleRecyclerItemClick(
                parent as RecyclerView,
                v
            )
        }
        return AlbumViewHolder(recyclerViewItem)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        // Cet country in countries via position
        val album = albums[position]
        holder.albumNameView.text = album.nameAlbum
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    // Click on RecyclerView Item.
    private fun handleRecyclerItemClick(recyclerView: RecyclerView, itemView: View) {
        val itemPosition = recyclerView.getChildLayoutPosition(itemView)
        val album = albums[itemPosition]
        Toast.makeText(context, album.nameAlbum, Toast.LENGTH_LONG).show()
    }

    init {
        mLayoutInflater = LayoutInflater.from(context)
    }
}