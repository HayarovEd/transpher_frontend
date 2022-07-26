package com.edurda77.transpher_frontend

import android.app.Application
import com.edurda77.transpher_frontend.coin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(viewModelModule)
        }
    }
}