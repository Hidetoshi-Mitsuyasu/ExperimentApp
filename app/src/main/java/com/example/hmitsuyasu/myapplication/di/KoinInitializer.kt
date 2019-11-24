package com.example.hmitsuyasu.myapplication.di

import android.app.Application
import com.example.hmitsuyasu.myapplication.di.module.preferencesModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KoinInitializer(private val application: Application) {
    fun init() {
        startKoin {
            androidLogger()
            androidContext(application)
            modules(
                    listOf(
                            preferencesModules
                    )
            )
        }
    }
}