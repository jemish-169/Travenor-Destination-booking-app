package com.app.travenor.routes

import kotlinx.serialization.Serializable

sealed class ProfileRoute {

    @Serializable
    data object ProfileScreen : ProfileRoute()

    @Serializable
    data object EditProfileScreen : ProfileRoute()
}