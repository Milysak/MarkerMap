package com.example.markermap.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFC1D7FC),
    onPrimary = Color(0xFF032B55),
    background = Color(0xFF000D1B),
    secondary = Color(0xFF041429),
    onSecondary = Color(0xFFEFF5FD),
    tertiary = Pink80,
    onSurface = Color(0xFFEBF0FD),
    outline = Color(0xFFEBF0FD).copy(alpha = 0.75f),
    onSurfaceVariant = Color(0xFFEBF0FD).copy(alpha = 0.75f)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF0F549B),
    onPrimary = Color(0xFFEDF4FF),
    background = Color(0xFFF2F6FF),
    secondary = Color(0xFFF9FCFF),
    onSecondary = Color(0xFF1E569E),
    tertiary = Pink40,
    onSurface = Color(0xFF001227),
    outline = Color(0xFF001227).copy(alpha = 0.75f),
    onSurfaceVariant = Color(0xFF001227).copy(alpha = 0.75f)

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

@Composable
fun MarkerMapTheme(
        darkTheme: Boolean = isSystemInDarkTheme(),
        // Dynamic color is available on Android 12+
        dynamicColor: Boolean = true,
        content: @Composable () -> Unit
) {

    val colorScheme = if (!darkTheme) {
        LightColorScheme
    } else {
        DarkColorScheme
    }

    val systemUiController = rememberSystemUiController()

    if(darkTheme){
        systemUiController.setSystemBarsColor(color = colorScheme.background, darkIcons = false)
        systemUiController.setNavigationBarColor( color = colorScheme.background, darkIcons = false)
    }else{
        systemUiController.setSystemBarsColor(color = colorScheme.background, darkIcons = true)
        systemUiController.setNavigationBarColor( color = colorScheme.background, darkIcons = true)
    }
    MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
    )
}