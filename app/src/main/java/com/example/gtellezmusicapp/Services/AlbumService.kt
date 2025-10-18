package com.example.gtellezmusicapp.Services

import com.example.gtellezmusicapp.models.Album
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumService {
    @GET("albums")
    suspend fun getAllAlbums() : List<Album>

    @GET("albums/{id}")
    suspend fun getAlbumById(@Path("id") id:String) : Album
}
