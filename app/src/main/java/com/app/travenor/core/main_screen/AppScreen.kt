package com.app.travenor.core.main_screen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.app.travenor.features.calender.presentation.CalenderScreen
import com.app.travenor.features.home.presentation.HomeScreen
import com.app.travenor.features.messages.presentation.MessagesScreen
import com.app.travenor.features.profile.presentation.ProfileScreen
import com.app.travenor.features.search.presentation.SearchScreen
import com.app.travenor.routes.AppRoute.CalenderAppRoute
import com.app.travenor.routes.AppRoute.HomeAppRoute
import com.app.travenor.routes.AppRoute.MessagesAppRoute
import com.app.travenor.routes.AppRoute.ProfileAppRoute
import com.app.travenor.routes.AppRoute.SearchAppRoute

@Composable
fun AppScreen() {
    val appNavController = rememberNavController()
    val navBackStackEntry by appNavController.currentBackStackEntryAsState()

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
                        onNotificationClick = { }
                    )
                }

                composable<CalenderAppRoute> {
                    CalenderScreen(innerPadding = innerPadding)
                }

                composable<SearchAppRoute> {
                    SearchScreen(innerPadding = innerPadding)
                }

                composable<MessagesAppRoute> {
                    MessagesScreen(innerPadding = innerPadding)
                }

                composable<ProfileAppRoute> {
                    ProfileScreen(innerPadding = innerPadding)
                }
            }
        }
    )
}