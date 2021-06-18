package com.techzone.airlinesapp.util

import android.app.Application
import android.content.Context

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        HelperClass.applicationContext=this
    }
}