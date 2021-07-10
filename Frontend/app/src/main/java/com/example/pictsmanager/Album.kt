package com.example.pictsmanager

internal class Album(
    var nameAlbum: String,
    var id: Int
) {

    override fun toString(): String {
        return "$nameAlbum $id"
    }
}