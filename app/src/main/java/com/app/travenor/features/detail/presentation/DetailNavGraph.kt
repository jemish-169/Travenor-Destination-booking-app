package com.app.travenor.features.detail.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.travenor.animation.AnimateScreen
import com.app.travenor.core.extensions.plus
import com.app.travenor.routes.DetailRoute.DetailScreen

@Composable
fun DetailNavGraph(
    innerPadding: PaddingValues,
    onBackOrFinish: () -> Unit
) {
    val detailNavController = rememberNavController()

    Scaffold(
        content = { nestedInnerPadding ->
            NavHost(
                navController = detailNavController,
                startDestination = DetailScreen
            ) {
                composable<DetailScreen>(
                    popEnterTransition = AnimateScreen.rightPopEnterTransition(),
                    enterTransition = AnimateScreen.leftEnterTransition(),
                    popExitTransition = AnimateScreen.rightPopExitTransition(),
                    exitTransition = AnimateScreen.leftExitTransition()
                ) {
                    DetailScreen(
                        innerPadding = innerPadding.plus(nestedInnerPadding),
                        onBackClick = { handleBackClick(detailNavController, onBackOrFinish) },
                        onBookNowClick = {},
                    )
                }
            }
        }
    )
}

private fun handleBackClick(detailNavController: NavHostController, onBackOrFinish: () -> Unit) {
    if (detailNavController.previousBackStackEntry == null) onBackOrFinish()
    else detailNavController.navigateUp()
}