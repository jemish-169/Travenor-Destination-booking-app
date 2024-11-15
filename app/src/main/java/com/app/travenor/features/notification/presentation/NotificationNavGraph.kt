package com.app.travenor.features.notification.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.travenor.routes.NotificationRoute.NotificationScreen

@Composable
fun NotificationNavGraph(onBackOrFinish: () -> Unit) {
    val notificationNavController = rememberNavController()

    Scaffold(
        content = { innerPadding ->
            NavHost(
                navController = notificationNavController,
                startDestination = NotificationScreen
            ) {
                composable<NotificationScreen> {
                    NotificationScreen(
                        innerPadding = innerPadding,
                        onBackClick = { handleBackClick(notificationNavController, onBackOrFinish) },
                        onClearAllClicked = { _ -> }
                    )
                }
            }
        }
    )
}

fun handleBackClick(appNavController: NavHostController, onBackOrFinish: () -> Unit) {
    if (appNavController.previousBackStackEntry == null) onBackOrFinish()
    else appNavController.navigateUp()
}