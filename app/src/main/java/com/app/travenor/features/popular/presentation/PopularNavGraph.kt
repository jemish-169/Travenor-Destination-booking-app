package com.app.travenor.features.popular.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.travenor.animation.AnimateScreen
import com.app.travenor.core.extensions.plus
import com.app.travenor.routes.PopularRoute.PopularScreen
import com.app.travenor.sample_data.DetailPlace
import com.app.travenor.sample_data.toDetailPlace

@Composable
fun PopularNavGraph(
    innerPadding: PaddingValues,
    onBackOrFinish: () -> Unit,
    onItemClick: (DetailPlace) -> Unit
) {
    val popularNavController = rememberNavController()

    Scaffold(
        content = { nestedInnerPadding ->
            NavHost(
                navController = popularNavController,
                startDestination = PopularScreen
            ) {
                composable<PopularScreen>(
                    popEnterTransition = AnimateScreen.rightPopEnterTransition(),
                    enterTransition = AnimateScreen.leftEnterTransition(),
                    popExitTransition = AnimateScreen.rightPopExitTransition(),
                    exitTransition = AnimateScreen.leftExitTransition()
                ) {
                    PopularsScreen(
                        innerPadding = innerPadding.plus(nestedInnerPadding),
                        onItemClick = { onItemClick(it.toDetailPlace()) },
                        onBackClick = { handleBackClick(popularNavController, onBackOrFinish) }
                    )
                }
            }
        }
    )
}

private fun handleBackClick(popularNavController: NavHostController, onBackOrFinish: () -> Unit) {
    if (popularNavController.previousBackStackEntry == null) onBackOrFinish()
    else popularNavController.navigateUp()
}