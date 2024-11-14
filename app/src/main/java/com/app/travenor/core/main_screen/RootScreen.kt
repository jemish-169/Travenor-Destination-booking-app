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
import com.app.travenor.features.onboarding.presentation.OnBoardingScreen
import com.app.travenor.routes.AppScreen
import com.app.travenor.routes.ForgotPassScreen
import com.app.travenor.routes.OnBoardingScreen
import com.app.travenor.routes.OtpVerifyScreen
import com.app.travenor.routes.SignInScreen
import com.app.travenor.routes.SignUpScreen

@Composable
fun RootScreen(
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
                            rootNavController.navigate(AppScreen) {
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
                            rootNavController.navigate(AppScreen) {
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
                            rootNavController.navigate(AppScreen) {
                                setOnboarded(true)
                                popUpTo(SignInScreen) {
                                    inclusive = true
                                }
                            }
                        }
                    )
                }

                composable<AppScreen> {
                    AppScreen()
                }
            }
        }
    )
}