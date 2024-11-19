package com.app.travenor.features.notification.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.app.travenor.features.notification.presentation.notification_detail.NotificationDetailScreen
import com.app.travenor.features.notification.presentation.notification_list.NotificationListScreen
import com.app.travenor.routes.NotificationRoute.NotificationDetailScreen
import com.app.travenor.routes.NotificationRoute.NotificationListScreen
import com.app.travenor.sample_data.Notification
import kotlin.reflect.typeOf

@Composable
fun NotificationNavGraph(onBackOrFinish: () -> Unit) {
    val notificationNavController = rememberNavController()

    Scaffold(
        content = { innerPadding ->
            NavHost(
                navController = notificationNavController,
                startDestination = NotificationListScreen
            ) {
                composable<NotificationListScreen> {
                    NotificationListScreen(
                        innerPadding = innerPadding,
                        onBackClick = { handleBackClick(notificationNavController, onBackOrFinish) },
                        onNotificationClick = { notificationType, notification ->
                            notificationNavController.navigate(
                                NotificationDetailScreen(
                                    notificationType = notificationType,
                                    notification = notification
                                )
                            )
                        },
                        onClearAllClicked = { _ -> }
                    )
                }

                composable<NotificationDetailScreen>(
                    typeMap =mapOf(
                        typeOf<Notification>() to CustomNavType.NotificationNavType,
                    )
                ) {
                    val args = it.toRoute<NotificationDetailScreen>()
                    NotificationDetailScreen(
                        innerPadding = innerPadding,
                        notificationType = args.notificationType,
                        notification = args.notification,
                        onBackClick = {
                            handleBackClick(
                                notificationNavController,
                                onBackOrFinish
                            )
                        },
                    )
                }
            }
        }
    )
}

private fun handleBackClick(notificationNavController: NavHostController, onBackOrFinish: () -> Unit) {
    if (notificationNavController.previousBackStackEntry == null) onBackOrFinish()
    else notificationNavController.navigateUp()
}