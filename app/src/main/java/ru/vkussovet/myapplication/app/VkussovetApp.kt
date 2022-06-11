package ru.vkussovet.myapplication.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.vkussovet.myapplication.di.appModule

class VkussovetApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@VkussovetApp)
            modules(appModule)
        }

    }


}