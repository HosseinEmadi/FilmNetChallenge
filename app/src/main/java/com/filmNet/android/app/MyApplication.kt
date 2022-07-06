package com.filmNet.android.app

import android.app.Application
import com.filmNet.android.app.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(
                musicsModule
            ))
            androidContext(applicationContext)
        }
    }
}