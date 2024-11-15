package com.app.travenor.core.utils

import com.app.travenor.core.preferences.Preferences
import com.app.travenor.routes.RootRoute.AppNavGraph
import com.app.travenor.routes.RootRoute.OnBoardingScreen

fun getStartDestination(): Any {
    return if (Preferences.getIsOnboarded()) AppNavGraph
    else OnBoardingScreen
}