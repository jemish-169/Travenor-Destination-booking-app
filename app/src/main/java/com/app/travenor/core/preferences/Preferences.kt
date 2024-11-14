package com.app.travenor.core.preferences

import android.content.Context
import android.content.SharedPreferences
import com.app.travenor.core.utils.Constants
import com.app.travenor.core.utils.Constants.Companion.IS_ONBOARDED

class Preferences {

    companion object {

        private lateinit var appPref: SharedPreferences

        fun getInstance(context: Context): SharedPreferences {
            if (!Companion::appPref.isInitialized) appPref =
                context.getSharedPreferences(Constants.DATA, Context.MODE_PRIVATE)
            return appPref
        }

        fun getIsOnboarded(): Boolean {
            return appPref.getBoolean(IS_ONBOARDED, false)
        }

        fun setIsOnboarded(isOnBoarded: Boolean) {
            appPref.edit().putBoolean(IS_ONBOARDED, isOnBoarded).apply()
        }

        fun clearAllPref() {
            appPref.edit().remove(IS_ONBOARDED).apply()
        }
    }
}
