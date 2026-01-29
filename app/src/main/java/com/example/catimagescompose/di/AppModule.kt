package com.example.catimagescompose.di

import com.example.catimagescompose.data.ImageDataRepository
import com.example.catimagescompose.network.RetrofitModule
import com.example.catimagescompose.ui.ImageViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    single { RetrofitModule.provideBaseUrl() }
    single { RetrofitModule.provideRetrofit(get()) }
    single { RetrofitModule.provideApiService(get()) }
    single { ImageDataRepository(get()) }
    viewModelOf(::ImageViewModel)
}