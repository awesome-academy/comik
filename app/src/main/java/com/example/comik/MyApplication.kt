package com.example.comik

import android.app.Application
import com.example.comik.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                listOf(
                    dbModule,
                    repoComicModule,
                    networkModule,
                    apiModule,
                    repoEventModule,
                    viewModelModule
                )
            )
        }
    }
}
