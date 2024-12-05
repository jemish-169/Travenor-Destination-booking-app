package com.app.travenor.core.main_screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.travenor.core.preferences.Preferences
import com.app.travenor.core.utils.getStartDestination
import com.app.travenor.ui.theme.TravenorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContent {
            val rootNavController = rememberNavController()
            TravenorTheme {
                RootNavGraph(
                    rootNavController = rootNavController,
                    startDestination = getStartDestination(),
                    setOnboarded = { isLogin ->
                        Preferences.setIsOnboarded(isLogin)
                    },
                    onBackOrFinish = { handleBackClick(rootNavController) },
                    clearAllPref = {
                        Preferences.clearAllPref()
                    }
                )
            }
        }
    }

    private fun handleBackClick(rootNavController: NavHostController) {
        if (rootNavController.previousBackStackEntry == null) finish()
        else rootNavController.navigateUp()
    }
}