package com.app.travenor.routes

import com.app.travenor.sample_data.DetailPlace
import kotlinx.serialization.Serializable

sealed class AppRoute {

    val name: String
        get() = this::class.qualifiedName ?: (this::class.simpleName ?: this::class.toString())

    @Serializable
    data object HomeAppRoute : AppRoute()

    @Serializable
    data object PopularAppRoute : AppRoute()

    @Serializable
    data object SearchAppRoute : AppRoute()

    @Serializable
    data object FavouritesAppRoute : AppRoute()

    @Serializable
    data object ProfileAppRoute : AppRoute()

    @Serializable
    data object NotificationNavGraph : AppRoute()

    @Serializable
    data class DetailNavGraph(val detailPlace: DetailPlace) : AppRoute()
}