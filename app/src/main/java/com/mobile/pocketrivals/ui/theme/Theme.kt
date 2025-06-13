package com.mobile.pocketrivals.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme =
  darkColorScheme(
    primary = White,
    secondary = Black10,
    tertiary = Gold,
    background = DarkThemeBackground,
    onPrimary = White,
    onSecondary = Grey10,
    onSurface = Color.Gray,
    onBackground = LightBlack,
    surface = DarkThemeBackground,
  )

private val LightColorScheme =
  lightColorScheme(
    primary = White,
    secondary = Black10,
    tertiary = Gold,
    background = White,
    onPrimary = Black10,
    onSecondary = Grey10,
    onSurface = Color.Gray,
    onBackground = LightBlack,
    surface = White,

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
  )

val ColorScheme.searchBarText: Color
  get() = SearchBarGray

@Composable
fun PocketRivalsTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit
) {
  val colorScheme =
    when {
      darkTheme -> DarkColorScheme
      else -> LightColorScheme
    }

  MaterialTheme(colorScheme = colorScheme, typography = Typography, content = content)
}
