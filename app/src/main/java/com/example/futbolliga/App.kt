package com.example.futbolliga

import android.app.Application
import com.example.futbolliga.di.appModule
import com.example.futbolliga.di.dataModule
import com.example.futbolliga.di.domainModule
import com.example.futbolliga.di.localModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf(appModule, dataModule, domainModule, localModule))
            androidContext(this@App)
        }
    }
}