package com.app.travenor.routes

import kotlinx.serialization.Serializable

sealed class PopularRoute {

    @Serializable
    data object PopularScreen : PopularRoute()
}