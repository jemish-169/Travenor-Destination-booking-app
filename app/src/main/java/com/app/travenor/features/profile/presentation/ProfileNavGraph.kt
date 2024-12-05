package com.app.travenor.features.profile.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.travenor.animation.AnimateScreen
import com.app.travenor.core.extensions.plus
import com.app.travenor.features.profile.presentation.profile_edit.EditProfileScreen
import com.app.travenor.features.profile.presentation.profile_view.ProfileScreen
import com.app.travenor.routes.ProfileRoute.EditProfileScreen
import com.app.travenor.routes.ProfileRoute.ProfileScreen

@Composable
fun ProfileNavGraph(
    onBackOrFinish: () -> Unit,
    innerPadding: PaddingValues,
    onSignOut: () -> Unit
) {
    val profileNavController = rememberNavController()

    Scaffold(
        content = { nestedInnerPadding ->
            NavHost(
                navController = profileNavController,
                startDestination = ProfileScreen
            ) {
                composable<ProfileScreen>(
                    popEnterTransition = AnimateScreen.rightPopEnterTransition(),
                    enterTransition = AnimateScreen.leftEnterTransition(),
                    popExitTransition = AnimateScreen.rightPopExitTransition(),
                    exitTransition = AnimateScreen.leftExitTransition()
                ) {
                    ProfileScreen(
                        innerPadding = innerPadding.plus(nestedInnerPadding),
                        onBackClick = { handleBackClick(profileNavController, onBackOrFinish) },
                        onEditClick = { profileNavController.navigate(EditProfileScreen) },
                        onSignOut = onSignOut

                    )
                }
                composable<EditProfileScreen>(
                    popEnterTransition = AnimateScreen.rightPopEnterTransition(),
                    enterTransition = AnimateScreen.leftEnterTransition(),
                    popExitTransition = AnimateScreen.rightPopExitTransition(),
                    exitTransition = AnimateScreen.leftExitTransition()
                ) {
                    EditProfileScreen(
                        innerPadding = innerPadding.plus(nestedInnerPadding),
                        onBackClick = { handleBackClick(profileNavController, onBackOrFinish) },
                        onSaveProfile = { handleBackClick(profileNavController, onBackOrFinish) }
                    )
                }
            }
        }
    )
}

private fun handleBackClick(profileNavController: NavHostController, onBackOrFinish: () -> Unit) {
    if (profileNavController.previousBackStackEntry == null) onBackOrFinish()
    else profileNavController.navigateUp()
}