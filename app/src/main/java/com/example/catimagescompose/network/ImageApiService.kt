package com.example.catimagescompose.network

import com.example.catimagescompose.data.ImageDataModel
import retrofit2.http.GET

interface ImageApiService {
    @GET("cats")
    suspend fun getData(): List<ImageDataModel>
}