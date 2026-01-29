package com.example.catimagescompose.data

import com.example.catimagescompose.network.ImageApiService
import com.example.catimagescompose.data.ImageDataModel


class ImageDataRepository (private val apiService: ImageApiService) {

    suspend fun fetchData(): List<ImageDataModel> {
        return apiService.getData()
    }
}