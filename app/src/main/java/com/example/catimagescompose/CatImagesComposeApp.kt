package com.example.catimagescompose

import android.app.Application
import com.example.catimagescompose.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CatImagesComposeApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CatImagesComposeApp)
            modules(appModule)
        }
    }
}