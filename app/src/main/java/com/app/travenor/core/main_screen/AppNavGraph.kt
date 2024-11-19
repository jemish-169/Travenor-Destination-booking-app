package com.app.travenor.core.main_screen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.travenor.features.calender.presentation.CalenderScreen
import com.app.travenor.features.home.presentation.HomeScreen
import com.app.travenor.features.messages.presentation.MessagesScreen
import com.app.travenor.features.profile.presentation.ProfileNavGraph
import com.app.travenor.features.search.presentation.SearchNavGraph
import com.app.travenor.routes.AppRoute.CalenderAppRoute
import com.app.travenor.routes.AppRoute.HomeAppRoute
import com.app.travenor.routes.AppRoute.MessagesAppRoute
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
            AppBottomBar(appNavController)
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
                            appNavController.navigate(ProfileAppRoute)
                        }
                    )
                }

                composable<CalenderAppRoute> {
                    CalenderScreen(innerPadding = innerPadding)
                }

                composable<SearchAppRoute> {
                    SearchNavGraph(
                        onBackOrFinish = {
                            handleBackClick(
                                appNavController,
                                onBackOrFinish
                            )
                        }
                    )
                }

                composable<MessagesAppRoute> {
                    MessagesScreen(innerPadding = innerPadding)
                }

                composable<ProfileAppRoute> {
                    ProfileNavGraph(
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