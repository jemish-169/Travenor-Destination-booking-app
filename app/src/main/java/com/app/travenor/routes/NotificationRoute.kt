package com.app.travenor.routes

import kotlinx.serialization.Serializable

sealed class NotificationRoute {

    @Serializable
    data object NotificationScreen : NotificationRoute()
}