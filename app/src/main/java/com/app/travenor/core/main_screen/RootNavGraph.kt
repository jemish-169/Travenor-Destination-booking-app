package com.app.travenor.core.main_screen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.travenor.features.auth.presentation.ForgotPassScreen
import com.app.travenor.features.auth.presentation.OtpVerifyScreen
import com.app.travenor.features.auth.presentation.SignInScreen
import com.app.travenor.features.auth.presentation.SignUpScreen
import com.app.travenor.features.notification.presentation.NotificationNavGraph
import com.app.travenor.features.onboarding.presentation.OnBoardingScreen
import com.app.travenor.routes.AppRoute.NotificationNavGraph
import com.app.travenor.routes.RootRoute.AppNavGraph
import com.app.travenor.routes.RootRoute.ForgotPassScreen
import com.app.travenor.routes.RootRoute.OnBoardingScreen
import com.app.travenor.routes.RootRoute.OtpVerifyScreen
import com.app.travenor.routes.RootRoute.SignInScreen
import com.app.travenor.routes.RootRoute.SignUpScreen

@Composable
fun RootNavGraph(
    rootNavController: NavHostController,
    startDestination: Any,
    setOnboarded: (Boolean) -> Unit,
    onBackOrFinish: () -> Unit,
) {
    Scaffold(
        content = { innerPadding ->
            NavHost(
                navController = rootNavController,
                startDestination = startDestination
            ) {
                composable<OnBoardingScreen> {
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

                composable<SignInScreen> {
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

                composable<SignUpScreen> {
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

                composable<ForgotPassScreen> {
                    ForgotPassScreen(
                        innerPadding = innerPadding,
                        onBackClick = { onBackOrFinish() },
                        validateAndMove = { _ -> rootNavController.navigate(OtpVerifyScreen) }
                    )
                }

                composable<OtpVerifyScreen> {
                    OtpVerifyScreen(
                        innerPadding = innerPadding,
                        onBackClick = { onBackOrFinish() },
                        validateAndMove = { _ ->
                            rootNavController.navigate(AppNavGraph) {
                                setOnboarded(true)
                                popUpTo(SignInScreen) {
                                    inclusive = true
                                }
                            }
                        }
                    )
                }

                composable<AppNavGraph> {
                    AppNavGraph(onBackOrFinish = onBackOrFinish, navigateToNotification = {rootNavController.navigate(NotificationNavGraph)})
                }


                composable<NotificationNavGraph> {
                    NotificationNavGraph(
                        onBackOrFinish = {
                            handleBackClick(rootNavController, onBackOrFinish)
                        }
                    )
                }
            }
        }
    )
}