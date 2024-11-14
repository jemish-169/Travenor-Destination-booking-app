package com.app.travenor.app

import android.app.Application
import com.app.travenor.core.preferences.Preferences

class TravenorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Preferences.getInstance(applicationContext)
    }
}