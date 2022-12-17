package com.example.activityishaswindow

import android.app.Application

class App :Application() {

    override fun onCreate() {
        super.onCreate()
        CustomWindowManager.init(this)
    }



}