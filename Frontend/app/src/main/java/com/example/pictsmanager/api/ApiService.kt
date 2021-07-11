package com.example.pictsmanager.api

import com.example.pictsmanager.models.Album
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("/api/albums/{user_id}")
    suspend fun getListAlbums(@Path("user_id") userId: Int): Response<MutableList<Album>>
}