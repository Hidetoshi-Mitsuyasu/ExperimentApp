package com.example.hmitsuyasu.myapplication

import android.app.Application
import com.example.hmitsuyasu.myapplication.di.KoinInitializer

class SampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInitializer(this).init()
    }
}