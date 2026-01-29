package com.example.catimagescompose.network

import com.example.catimagescompose.network.ImageApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import kotlin.jvm.java

val json = Json { ignoreUnknownKeys = true }

object RetrofitModule {


    fun provideBaseUrl(): String = "https://cataas.com/api/"


    fun provideRetrofit(baseUrl: String): Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()


    fun provideApiService(retrofit: Retrofit): ImageApiService = retrofit.create(ImageApiService::class.java)

}