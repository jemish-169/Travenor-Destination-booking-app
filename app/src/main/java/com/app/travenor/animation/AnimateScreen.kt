package com.app.travenor.animation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween

object AnimateScreen {
    fun leftEnterTransition(): AnimatedContentTransitionScope<*>.() -> EnterTransition? = {
        slideIntoContainer(
            AnimatedContentTransitionScope.SlideDirection.Left,
            animationSpec = tween(300)
        )
    }

    fun rightPopEnterTransition(): AnimatedContentTransitionScope<*>.() -> EnterTransition? = {
        slideIntoContainer(
            AnimatedContentTransitionScope.SlideDirection.Right,
            animationSpec = tween(300)
        )
    }

    fun leftExitTransition(): AnimatedContentTransitionScope<*>.() -> ExitTransition? = {
        slideOutOfContainer(
            AnimatedContentTransitionScope.SlideDirection.Left,
            animationSpec = tween(300)
        )
    }

    fun rightPopExitTransition(): AnimatedContentTransitionScope<*>.() -> ExitTransition? = {
        slideOutOfContainer(
            AnimatedContentTransitionScope.SlideDirection.Right,
            animationSpec = tween(300)
        )
    }
    fun topEnterTransition(): AnimatedContentTransitionScope<*>.() -> EnterTransition? = {
        slideIntoContainer(
            AnimatedContentTransitionScope.SlideDirection.Up,
            animationSpec = tween(300)
        )
    }

    fun bottomPopEnterTransition(): AnimatedContentTransitionScope<*>.() -> EnterTransition? = {
        slideIntoContainer(
            AnimatedContentTransitionScope.SlideDirection.Up,
            animationSpec = tween(300)
        )
    }

    fun topExitTransition(): AnimatedContentTransitionScope<*>.() -> ExitTransition? = {
        slideOutOfContainer(
            AnimatedContentTransitionScope.SlideDirection.Down,
            animationSpec = tween(300)
        )
    }

    fun bottomPopExitTransition(): AnimatedContentTransitionScope<*>.() -> ExitTransition? = {
        slideOutOfContainer(
            AnimatedContentTransitionScope.SlideDirection.Down,
            animationSpec = tween(300)
        )
    }
}