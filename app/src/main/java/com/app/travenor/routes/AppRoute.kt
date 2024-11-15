package com.app.travenor.routes

import kotlinx.serialization.Serializable

sealed class AppRoute {

    val name: String
        get() = this::class.qualifiedName ?: (this::class.simpleName ?: this::class.toString())

    @Serializable
    data object HomeAppRoute : AppRoute()

    @Serializable
    data object CalenderAppRoute : AppRoute()

    @Serializable
    data object SearchAppRoute : AppRoute()

    @Serializable
    data object MessagesAppRoute : AppRoute()

    @Serializable
    data object ProfileAppRoute : AppRoute()

    @Serializable
    data object NotificationNavGraph : AppRoute()
}