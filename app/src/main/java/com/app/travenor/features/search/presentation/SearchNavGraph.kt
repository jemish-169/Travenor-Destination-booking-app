package com.app.travenor.features.search.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.travenor.animation.AnimateScreen
import com.app.travenor.core.extensions.plus
import com.app.travenor.routes.SearchRoute.SearchScreen

@Composable
fun SearchNavGraph(onBackOrFinish: () -> Unit, innerPadding: PaddingValues, onItemClick: () -> Unit) {
    val searchNavController = rememberNavController()

    Scaffold(
        content = { nestedInnerPadding ->
            NavHost(
                navController = searchNavController,
                startDestination = SearchScreen
            ) {
                composable<SearchScreen>(
                    popEnterTransition = AnimateScreen.rightPopEnterTransition(),
                    enterTransition = AnimateScreen.leftEnterTransition(),
                    popExitTransition = AnimateScreen.rightPopExitTransition(),
                    exitTransition = AnimateScreen.leftExitTransition()
                ) {
                    SearchScreen(
                        innerPadding = innerPadding.plus(nestedInnerPadding),
                        onItemClick = onItemClick,
                        onBackClick = { handleBackClick(searchNavController, onBackOrFinish) }
                    )
                }
            }
        }
    )
}

private fun handleBackClick(searchNavController: NavHostController, onBackOrFinish: () -> Unit) {
    if (searchNavController.previousBackStackEntry == null) onBackOrFinish()
    else searchNavController.navigateUp()
}