package com.app.travenor.core.main_screen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.travenor.features.favourites.presentation.FavouriteNavGraph
import com.app.travenor.features.home.presentation.HomeScreen
import com.app.travenor.features.popular.presentation.PopularNavGraph
import com.app.travenor.features.profile.presentation.ProfileNavGraph
import com.app.travenor.features.search.presentation.SearchNavGraph
import com.app.travenor.routes.AppRoute.FavouritesAppRoute
import com.app.travenor.routes.AppRoute.HomeAppRoute
import com.app.travenor.routes.AppRoute.PopularAppRoute
import com.app.travenor.routes.AppRoute.ProfileAppRoute
import com.app.travenor.routes.AppRoute.SearchAppRoute

@Composable
fun AppNavGraph(
    onBackOrFinish: () -> Unit,
    navigateToNotification: () -> Unit
) {
    val appNavController = rememberNavController()

    Scaffold(
        bottomBar = {
            AppBottomBar(appNavController = appNavController)
        },
        content = { innerPadding ->
            NavHost(
                navController = appNavController,
                startDestination = HomeAppRoute
            ) {
                composable<HomeAppRoute> {
                    HomeScreen(
                        innerPadding = innerPadding,
                        onNotificationClick = navigateToNotification,
                        onProfileClick = {
                            appNavController.navigate(ProfileAppRoute) {
                                popUpTo(appNavController.graph.findStartDestination().id) {
                                    saveState = false
                                }
                                launchSingleTop = true
                                restoreState = false
                            }
                        }
                    )
                }

                composable<PopularAppRoute> {
                    PopularNavGraph(
                        innerPadding = innerPadding,
                        onBackOrFinish = { handleBackClick(appNavController, onBackOrFinish) }
                    )
                }

                composable<SearchAppRoute> {
                    SearchNavGraph(
                        innerPadding = innerPadding,
                        onBackOrFinish = {
                            handleBackClick(
                                appNavController,
                                onBackOrFinish
                            )
                        }
                    )
                }

                composable<FavouritesAppRoute> {
                    FavouriteNavGraph(
                        innerPadding = innerPadding,
                        onBackOrFinish = { handleBackClick(appNavController, onBackOrFinish) }
                    )
                }

                composable<ProfileAppRoute> {
                    ProfileNavGraph(
                        innerPadding = innerPadding,
                        onBackOrFinish = {
                            handleBackClick(
                                appNavController,
                                onBackOrFinish
                            )
                        }
                    )
                }
            }
        }
    )
}

private fun handleBackClick(appNavController: NavHostController, onBackOrFinish: () -> Unit) {
    if (appNavController.previousBackStackEntry == null) onBackOrFinish()
    else appNavController.navigateUp()
}