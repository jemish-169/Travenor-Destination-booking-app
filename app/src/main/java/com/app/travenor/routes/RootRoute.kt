package com.app.travenor.routes

import kotlinx.serialization.Serializable

sealed class RootRoute {
    @Serializable
    data object OnBoardingScreen : RootRoute()

    @Serializable
    data object SignInScreen : RootRoute()

    @Serializable
    data object SignUpScreen : RootRoute()

    @Serializable
    data object ForgotPassScreen : RootRoute()

    @Serializable
    data object OtpVerifyScreen : RootRoute()

    @Serializable
    data object AppNavGraph : RootRoute()
}