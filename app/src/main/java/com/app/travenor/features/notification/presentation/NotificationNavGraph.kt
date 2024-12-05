package com.app.travenor.features.notification.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.app.travenor.animation.AnimateScreen
import com.app.travenor.core.extensions.plus
import com.app.travenor.features.notification.presentation.notification_detail.NotificationDetailScreen
import com.app.travenor.features.notification.presentation.notification_list.NotificationListScreen
import com.app.travenor.routes.NotificationRoute.NotificationDetailScreen
import com.app.travenor.routes.NotificationRoute.NotificationListScreen
import com.app.travenor.sample_data.Notification
import kotlin.reflect.typeOf

@Composable
fun NotificationNavGraph(
    innerPadding: PaddingValues,
    onBackOrFinish: () -> Unit
) {
    val notificationNavController = rememberNavController()

    Scaffold(
        content = { notificationPadding ->
            NavHost(
                navController = notificationNavController,
                startDestination = NotificationListScreen
            ) {
                composable<NotificationListScreen>(
                    popEnterTransition = AnimateScreen.rightPopEnterTransition(),
                    enterTransition = AnimateScreen.leftEnterTransition(),
                    popExitTransition = AnimateScreen.rightPopExitTransition(),
                    exitTransition = AnimateScreen.leftExitTransition()
                ) {
                    NotificationListScreen(
                        innerPadding = notificationPadding.plus(innerPadding),
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
                    popEnterTransition = AnimateScreen.rightPopEnterTransition(),
                    enterTransition = AnimateScreen.leftEnterTransition(),
                    popExitTransition = AnimateScreen.rightPopExitTransition(),
                    exitTransition = AnimateScreen.leftExitTransition(),
                    typeMap =mapOf(
                        typeOf<Notification>() to NotificationCustomNav.NotificationNavType,
                    )
                ) {
                    val args = it.toRoute<NotificationDetailScreen>()
                    NotificationDetailScreen(
                        innerPadding = notificationPadding.plus(innerPadding),
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