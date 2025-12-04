package com.example.catimagescompose.data

import com.example.catimagescompose.network.ImageApiService
import com.example.catimagescompose.data.ImageDataModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageDataRepository @Inject constructor(private val apiService: ImageApiService) {

    suspend fun fetchData(): List<ImageDataModel> {
        return apiService.getData()
    }
}