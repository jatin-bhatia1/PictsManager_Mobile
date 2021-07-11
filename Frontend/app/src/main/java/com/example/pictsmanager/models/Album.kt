package com.example.pictsmanager.models

class Album(var Name: String, var Images: MutableList<Image>?) {

    override fun toString(): String {
        return "$Name"
    }
}