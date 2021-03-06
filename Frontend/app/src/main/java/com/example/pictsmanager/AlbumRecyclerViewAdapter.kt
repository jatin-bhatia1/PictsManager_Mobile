package com.example.pictsmanager

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.pictsmanager.models.Album

internal class CustomRecyclerViewAdapter(
    private val context: Context,
    private val albums: MutableList<Album>?
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
        // Cet country in countries via position
        if(albums != null){
            val album = albums[position]
            holder.albumNameView.text = album.Name
        }
    }

    override fun getItemCount(): Int {
        if (albums != null) {
            return albums.size
        }
        return 0
    }

    private fun handleRecyclerItemClick(recyclerView: RecyclerView, itemView: View) {
        if(albums != null){
            val itemPosition = recyclerView.getChildLayoutPosition(itemView)
            val album = albums[itemPosition]
            val intent = Intent(context, ListPicturesActivity::class.java)
            intent.putExtra("nameAlbum",album.Name)
            context.startActivity(intent)
        }
    }

}