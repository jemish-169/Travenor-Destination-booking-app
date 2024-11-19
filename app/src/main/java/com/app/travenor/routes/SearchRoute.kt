package com.app.travenor.routes

import kotlinx.serialization.Serializable

sealed class SearchRoute {

    @Serializable
    data object SearchScreen : SearchRoute()
}