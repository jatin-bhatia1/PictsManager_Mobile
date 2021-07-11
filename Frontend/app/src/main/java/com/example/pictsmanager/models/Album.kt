package com.example.pictsmanager.models

data class Album(var id: Int, var Name: String, var UserId: Int, var createdAt: String, var updatedAt: String) {

    override fun toString(): String {
        return "$Name"
    }
}