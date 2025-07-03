package com.example.caffeine

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CaffeineApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CaffeineApp)
            modules(
                listOf(

                )
            )
        }
    }
}