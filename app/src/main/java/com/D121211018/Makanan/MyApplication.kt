package com.D121211018.Makanan

import android.app.Application
import com.D121211018.Makanan.data.AppContainer
import com.D121211018.Makanan.data.DefaultAppContainer

class MyApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}