package com.example.pictsmanager.api

import com.example.pictsmanager.models.Album
import com.example.pictsmanager.models.User
import com.example.pictsmanager.viewmodels.PostAddAlbumViewModel
import com.example.pictsmanager.viewmodels.PostLoginUserViewModel
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @POST("api/login")
    fun postLogin(@Body user: PostLoginUserViewModel) : Call<User>

    @POST("api/albums")
    fun postAddAlbum(@Body album: PostAddAlbumViewModel): Call<Album>

    @GET("api/albums/{user_id}")
    fun getListAlbums(@Path("user_id") userId: Int): Call<MutableList<Album>>
}