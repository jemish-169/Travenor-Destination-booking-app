package com.app.travenor.features.popular.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.travenor.core.extensions.plus
import com.app.travenor.routes.PopularRoute.PopularScreen

@Composable
fun PopularNavGraph(
    innerPadding: PaddingValues,
    onBackOrFinish: () -> Unit
) {
    val popularNavController = rememberNavController()

    Scaffold(
        content = { nestedInnerPadding ->
            NavHost(
                navController = popularNavController,
                startDestination = PopularScreen
            ) {
                composable<PopularScreen> {
                    PopularsScreen(
                        innerPadding = innerPadding.plus(nestedInnerPadding),
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