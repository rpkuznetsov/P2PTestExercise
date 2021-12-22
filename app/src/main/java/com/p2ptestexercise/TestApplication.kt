package com.p2ptestexercise

import android.app.Application
import com.p2ptestexercise.di.apiModule
import com.p2ptestexercise.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // Koin
        startKoin {
            androidContext(this@TestApplication)
            modules(appModule + apiModule)
        }
    }
}
