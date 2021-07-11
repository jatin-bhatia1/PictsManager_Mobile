package com.example.pictsmanager

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

internal class CustomRecyclerViewAdapter(
    private val context: Context,
    private val albums: ArrayList<Album>
) : RecyclerView.Adapter<AlbumViewHolder>() {
    private val mLayoutInflater: LayoutInflater = LayoutInflater.from(context)
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
        val album = albums[position]
        holder.albumNameView.text = album.nameAlbum
        album.isDelete = holder.albumDeleteView.isChecked
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    private fun handleRecyclerItemClick(recyclerView: RecyclerView, itemView: View) {
        val itemPosition = recyclerView.getChildLayoutPosition(itemView)
        val album = albums[itemPosition]
        val intent = Intent(context, ListPicturesActivity::class.java)
        intent.putExtra("nameAlbum",album.nameAlbum)
        context.startActivity(intent)
    }

}