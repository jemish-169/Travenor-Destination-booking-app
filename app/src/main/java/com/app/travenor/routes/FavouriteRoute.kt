package com.app.travenor.routes

import kotlinx.serialization.Serializable

sealed class FavouriteRoute {

    @Serializable
    data object FavouriteScreen : FavouriteRoute()
}