package com.filmNet.android.app

import android.app.Application
import com.filmNet.android.app.searchMovies.di.searchMoviesModule
import com.filmNet.android.di.appModule
import com.filmNet.android.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(
                appModule,
                networkModule,
                searchMoviesModule
            ))
            androidContext(applicationContext)
        }
    }
}