package com.app.travenor.features.favourites.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.travenor.core.extensions.plus
import com.app.travenor.routes.FavouriteRoute.FavouriteScreen

@Composable
fun FavouriteNavGraph(
    innerPadding: PaddingValues,
    onBackOrFinish: () -> Unit
) {
    val favouriteNavController = rememberNavController()

    Scaffold(
        content = { nestedInnerPadding ->
            NavHost(
                navController = favouriteNavController,
                startDestination = FavouriteScreen
            ) {
                composable<FavouriteScreen> {
                    FavouritesScreen(
                        innerPadding = innerPadding.plus(nestedInnerPadding),
                        onBackClick = { handleBackClick(favouriteNavController, onBackOrFinish) }
                    )
                }
            }
        }
    )
}

private fun handleBackClick(favouriteNavController: NavHostController, onBackOrFinish: () -> Unit) {
    if (favouriteNavController.previousBackStackEntry == null) onBackOrFinish()
    else favouriteNavController.navigateUp()
}