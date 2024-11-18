package com.app.travenor.routes

import com.app.travenor.sample_data.Notification
import kotlinx.serialization.Serializable

sealed class NotificationRoute {

    @Serializable
    data object NotificationListScreen : NotificationRoute()

    @Serializable
    data class NotificationDetailScreen(
        val notificationType: Int,
        val notification: Notification
    ) : NotificationRoute()
}