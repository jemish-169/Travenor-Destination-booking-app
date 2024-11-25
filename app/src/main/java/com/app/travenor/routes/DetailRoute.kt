package com.app.travenor.routes

import kotlinx.serialization.Serializable

sealed class DetailRoute {

    @Serializable
    data object DetailScreen : DetailRoute()
}