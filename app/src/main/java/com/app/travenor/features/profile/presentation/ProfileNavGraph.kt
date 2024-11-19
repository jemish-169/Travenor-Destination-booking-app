package com.app.travenor.features.profile.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.travenor.features.profile.presentation.profile_edit.EditProfileScreen
import com.app.travenor.features.profile.presentation.profile_view.ProfileScreen
import com.app.travenor.routes.ProfileRoute.EditProfileScreen
import com.app.travenor.routes.ProfileRoute.ProfileScreen

@Composable
fun ProfileNavGraph(onBackOrFinish: () -> Unit) {
    val profileNavController = rememberNavController()

    Scaffold(
        content = { innerPadding ->
            NavHost(
                navController = profileNavController,
                startDestination = ProfileScreen
            ) {
                composable<ProfileScreen> {
                    ProfileScreen(
                        innerPadding = innerPadding,
                        onBackClick = { handleBackClick(profileNavController, onBackOrFinish) },
                        onEditClick = { profileNavController.navigate(EditProfileScreen)}
                    )
                }
                composable<EditProfileScreen> {
                    EditProfileScreen(
                        innerPadding = innerPadding,
                        onBackClick = { handleBackClick(profileNavController, onBackOrFinish) },
                        onSaveProfile = {
                            handleBackClick(profileNavController, onBackOrFinish)
                        }
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