package com.example.pictsmanager

internal class Picture(
    var namePicture: String,
    var id: Int
) {

    override fun toString(): String {
        return "$namePicture $id"
    }
}