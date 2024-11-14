package com.app.travenor.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = primary,
    secondary = secondary,
    tertiary = lightGrey,
    background = black,
    surface = black,
    onPrimary = white,
    onSecondary = white,
    onTertiary = darkGrey,
    onBackground = white,
    onSurface = white
)

private val LightColorScheme = lightColorScheme(
    primary = primary,
    secondary = secondary,
    tertiary = darkGrey,
    background = white,
    surface = white,
    onPrimary = black,
    onSecondary = black,
    onTertiary = lightGrey,
    onBackground = black,
    onSurface = black
)

@Composable
fun TravenorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}