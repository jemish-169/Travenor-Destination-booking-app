package com.app.travenor.core.utils

import com.app.travenor.core.preferences.Preferences
import com.app.travenor.routes.AppScreen
import com.app.travenor.routes.OnBoardingScreen

fun getStartDestination(): Any {
    return if (Preferences.getIsOnboarded()) AppScreen
    else OnBoardingScreen
}