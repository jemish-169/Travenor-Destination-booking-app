package com.app.travenor.core.main_screen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.app.travenor.animation.AnimateScreen
import com.app.travenor.features.auth.presentation.ForgotPassScreen
import com.app.travenor.features.auth.presentation.OtpVerifyScreen
import com.app.travenor.features.auth.presentation.SignInScreen
import com.app.travenor.features.auth.presentation.SignUpScreen
import com.app.travenor.features.detail.presentation.DetailNavGraph
import com.app.travenor.features.detail.presentation.PlaceDetailCustomNav
import com.app.travenor.features.notification.presentation.NotificationNavGraph
import com.app.travenor.features.onboarding.presentation.OnBoardingScreen
import com.app.travenor.routes.AppRoute.DetailNavGraph
import com.app.travenor.routes.AppRoute.NotificationNavGraph
import com.app.travenor.routes.RootRoute.AppNavGraph
import com.app.travenor.routes.RootRoute.ForgotPassScreen
import com.app.travenor.routes.RootRoute.OnBoardingScreen
import com.app.travenor.routes.RootRoute.OtpVerifyScreen
import com.app.travenor.routes.RootRoute.SignInScreen
import com.app.travenor.routes.RootRoute.SignUpScreen
import com.app.travenor.sample_data.DetailPlace
import kotlin.reflect.typeOf

@Composable
fun RootNavGraph(
    rootNavController: NavHostController,
    startDestination: Any,
    setOnboarded: (Boolean) -> Unit,
    onBackOrFinish: () -> Unit,
    clearAllPref: () -> Unit,
) {
    Scaffold(
        content = { innerPadding ->
            NavHost(
                navController = rootNavController,
                startDestination = startDestination
            ) {
                composable<OnBoardingScreen>(
                    popEnterTransition = AnimateScreen.rightPopEnterTransition(),
                    enterTransition = AnimateScreen.leftEnterTransition(),
                    popExitTransition = AnimateScreen.rightPopExitTransition(),
                    exitTransition = AnimateScreen.leftExitTransition()
                ) {
                    OnBoardingScreen(
                        innerPadding = innerPadding,
                        onFinish = {
                            rootNavController.navigate(SignInScreen) {
                                popUpTo(OnBoardingScreen) {
                                    inclusive = true
                                }
                            }
                        }
                    )
                }

                composable<SignInScreen>(
                    popEnterTransition = AnimateScreen.rightPopEnterTransition(),
                    enterTransition = AnimateScreen.leftEnterTransition(),
                    popExitTransition = AnimateScreen.rightPopExitTransition(),
                    exitTransition = AnimateScreen.leftExitTransition()
                ) {
                    SignInScreen(
                        innerPadding = innerPadding,
                        onBackClick = { onBackOrFinish() },
                        validateAndMove = { _, _ ->
                            setOnboarded(true)
                            rootNavController.navigate(AppNavGraph) {
                                popUpTo(SignInScreen) {
                                    inclusive = true
                                }
                            }
                        },
                        moveToForgetPassword = { _ -> rootNavController.navigate(ForgotPassScreen) },
                        moveToSignUp = { rootNavController.navigate(SignUpScreen) }
                    )
                }

                composable<SignUpScreen>(
                    popEnterTransition = AnimateScreen.rightPopEnterTransition(),
                    enterTransition = AnimateScreen.leftEnterTransition(),
                    popExitTransition = AnimateScreen.rightPopExitTransition(),
                    exitTransition = AnimateScreen.leftExitTransition()
                ) {
                    SignUpScreen(
                        innerPadding = innerPadding,
                        onBackClick = { onBackOrFinish() },
                        validateAndMove = { _, _ ->
                            setOnboarded(true)
                            rootNavController.navigate(AppNavGraph) {
                                popUpTo(SignInScreen) {
                                    inclusive = true
                                }
                            }
                        }
                    )
                }

                composable<ForgotPassScreen>(
                    popEnterTransition = AnimateScreen.rightPopEnterTransition(),
                    enterTransition = AnimateScreen.leftEnterTransition(),
                    popExitTransition = AnimateScreen.rightPopExitTransition(),
                    exitTransition = AnimateScreen.leftExitTransition()
                ) {
                    ForgotPassScreen(
                        innerPadding = innerPadding,
                        onBackClick = { onBackOrFinish() },
                        validateAndMove = { _ -> rootNavController.navigate(OtpVerifyScreen) }
                    )
                }

                composable<OtpVerifyScreen>(
                    popEnterTransition = AnimateScreen.rightPopEnterTransition(),
                    enterTransition = AnimateScreen.leftEnterTransition(),
                    popExitTransition = AnimateScreen.rightPopExitTransition(),
                    exitTransition = AnimateScreen.leftExitTransition()
                ) {
                    OtpVerifyScreen(
                        innerPadding = innerPadding,
                        onBackClick = { onBackOrFinish() },
                        validateAndMove = { _ ->
                            setOnboarded(true)
                            rootNavController.navigate(AppNavGraph) {
                                popUpTo(SignInScreen) {
                                    inclusive = true
                                }
                            }
                        }
                    )
                }

                composable<AppNavGraph>(
                    popEnterTransition = AnimateScreen.rightPopEnterTransition(),
                    enterTransition = AnimateScreen.leftEnterTransition(),
                    popExitTransition = AnimateScreen.rightPopExitTransition(),
                    exitTransition = AnimateScreen.leftExitTransition()
                ) {
                    AppNavGraph(
                        innerPadding = innerPadding,
                        onBackOrFinish = onBackOrFinish,
                        navigateToNotification = { rootNavController.navigate(NotificationNavGraph) },
                        navigateToDetail = {
                            rootNavController.navigate(
                                DetailNavGraph(detailPlace = it)
                            )
                        },
                        onSignOut = {
                            rootNavController.navigate(OnBoardingScreen) {
                                popUpTo(AppNavGraph) {
                                    inclusive = true
                                }
                            }
                            clearAllPref()
                        }
                    )
                }

                composable<NotificationNavGraph>(
                    popEnterTransition = AnimateScreen.rightPopEnterTransition(),
                    enterTransition = AnimateScreen.leftEnterTransition(),
                    popExitTransition = AnimateScreen.rightPopExitTransition(),
                    exitTransition = AnimateScreen.leftExitTransition()
                ) {
                    NotificationNavGraph(
                        innerPadding = innerPadding,
                        onBackOrFinish = onBackOrFinish
                    )
                }

                composable<DetailNavGraph>(
                    popEnterTransition = AnimateScreen.rightPopEnterTransition(),
                    enterTransition = AnimateScreen.leftEnterTransition(),
                    popExitTransition = AnimateScreen.rightPopExitTransition(),
                    exitTransition = AnimateScreen.leftExitTransition(),
                    typeMap = mapOf(
                        typeOf<DetailPlace>() to PlaceDetailCustomNav.DetailPlaceNavType,
                    )
                ) {
                    val args = it.toRoute<DetailNavGraph>()
                    DetailNavGraph(
                        innerPadding = innerPadding,
                        onBackOrFinish = onBackOrFinish,
                        detailPlace = args.detailPlace
                    )
                }
            }
        }
    )
}