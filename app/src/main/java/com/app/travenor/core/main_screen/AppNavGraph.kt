package com.app.travenor.core.main_screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.travenor.animation.AnimateScreen
import com.app.travenor.core.extensions.plus
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
import com.app.travenor.sample_data.DetailPlace

@Composable
fun AppNavGraph(
    innerPadding: PaddingValues,
    onBackOrFinish: () -> Unit,
    navigateToNotification: () -> Unit,
    navigateToDetail: (DetailPlace) -> Unit,
    onSignOut: () -> Unit
) {
    val appNavController = rememberNavController()

    Scaffold(
        bottomBar = {
            AppBottomBar(appNavController = appNavController)
        },
        content = { appGraphPadding ->
            NavHost(
                navController = appNavController,
                startDestination = HomeAppRoute
            ) {
                composable<HomeAppRoute>(
                    popEnterTransition = AnimateScreen.rightPopEnterTransition(),
                    enterTransition = AnimateScreen.leftEnterTransition(),
                    popExitTransition = AnimateScreen.rightPopExitTransition(),
                    exitTransition = AnimateScreen.leftExitTransition()
                ) {
                    HomeScreen(
                        innerPadding = appGraphPadding.plus(innerPadding),
                        onNotificationClick = navigateToNotification,
                        onItemClick = navigateToDetail,
                        onProfileClick = {
                            appNavController.navigate(ProfileAppRoute) {
                                popUpTo(appNavController.graph.findStartDestination().id) {
                                    saveState = false
                                }
                                launchSingleTop = true
                                restoreState = false
                            }
                        },
                        navigateToPopular = {
                            appNavController.navigate(PopularAppRoute) {
                                popUpTo(appNavController.graph.findStartDestination().id) {
                                    saveState = false
                                }
                                launchSingleTop = true
                                restoreState = false
                            }
                        }
                    )
                }

                composable<PopularAppRoute>(
                    popEnterTransition = AnimateScreen.rightPopEnterTransition(),
                    enterTransition = AnimateScreen.leftEnterTransition(),
                    popExitTransition = AnimateScreen.rightPopExitTransition(),
                    exitTransition = AnimateScreen.leftExitTransition()
                ) {
                    PopularNavGraph(
                        innerPadding = appGraphPadding.plus(innerPadding),
                        onItemClick = navigateToDetail,
                        onBackOrFinish = { handleBackClick(appNavController, onBackOrFinish) }
                    )
                }

                composable<SearchAppRoute>(
                    popEnterTransition = AnimateScreen.bottomPopEnterTransition(),
                    enterTransition = AnimateScreen.topEnterTransition(),
                    popExitTransition = AnimateScreen.bottomPopExitTransition(),
                    exitTransition = AnimateScreen.topExitTransition()
                ) {
                    SearchNavGraph(
                        innerPadding = appGraphPadding.plus(innerPadding),
                        onItemClick = navigateToDetail,
                        onBackOrFinish = {
                            handleBackClick(
                                appNavController,
                                onBackOrFinish
                            )
                        }
                    )
                }

                composable<FavouritesAppRoute>(
                    popEnterTransition = AnimateScreen.rightPopEnterTransition(),
                    enterTransition = AnimateScreen.leftEnterTransition(),
                    popExitTransition = AnimateScreen.rightPopExitTransition(),
                    exitTransition = AnimateScreen.leftExitTransition()
                ) {
                    FavouriteNavGraph(
                        innerPadding = appGraphPadding.plus(innerPadding),
                        onItemClick = navigateToDetail,
                        onBackOrFinish = { handleBackClick(appNavController, onBackOrFinish) }
                    )
                }

                composable<ProfileAppRoute>(
                    popEnterTransition = AnimateScreen.rightPopEnterTransition(),
                    enterTransition = AnimateScreen.leftEnterTransition(),
                    popExitTransition = AnimateScreen.rightPopExitTransition(),
                    exitTransition = AnimateScreen.leftExitTransition()
                ) {
                    ProfileNavGraph(
                        innerPadding = appGraphPadding.plus(innerPadding),
                        onBackOrFinish = {
                            handleBackClick(
                                appNavController,
                                onBackOrFinish
                            )
                        },
                        onSignOut = onSignOut
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