package com.app.travenor.routes

import kotlinx.serialization.Serializable

@Serializable
sealed class AppRoute {

    val name: String
        get() = this::class.qualifiedName ?: (this::class.simpleName ?: this::class.toString())

    @Serializable
    object HomeAppRoute : AppRoute()

    @Serializable
    object CalenderAppRoute : AppRoute()

    @Serializable
    object SearchAppRoute : AppRoute()

    @Serializable
    object MessagesAppRoute : AppRoute()

    @Serializable
    object ProfileAppRoute : AppRoute()
}