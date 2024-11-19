package com.app.travenor.features.search.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.travenor.routes.SearchRoute.SearchScreen

@Composable
fun SearchNavGraph(onBackOrFinish: () -> Unit) {
    val searchNavController = rememberNavController()

    Scaffold(
        content = { innerPadding ->
            NavHost(
                navController = searchNavController,
                startDestination = SearchScreen
            ) {
                composable<SearchScreen> {
                    SearchScreen(
                        innerPadding = innerPadding,
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