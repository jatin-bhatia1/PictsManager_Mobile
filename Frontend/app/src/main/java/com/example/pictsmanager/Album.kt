package com.example.pictsmanager

class Album(
    var nameAlbum: String,
    var id: Int,
    var isDelete: Boolean
) {

    override fun toString(): String {
        return "$nameAlbum $id"
    }
}