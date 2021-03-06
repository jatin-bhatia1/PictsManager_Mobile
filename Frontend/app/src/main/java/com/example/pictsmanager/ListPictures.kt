package com.example.pictsmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.list_pictures.*

class ListPicturesActivity : AppCompatActivity() {
    private val pictures: ArrayList<Picture> = getListData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_pictures)
        recyclerView_picture.adapter = CustomRecyclerViewAdapter2(this, pictures)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView_picture.layoutManager = linearLayoutManager
        val nameAlbum = intent.getStringExtra("nameAlbum")
        textView_albumName.setText(nameAlbum)
    }

    private fun getListData(): ArrayList<Picture> {
        val list: ArrayList<Picture> = ArrayList<Picture>()
        return list
    }
}