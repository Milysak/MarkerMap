package com.example.markermap.screens

import android.icu.text.TimeZoneFormat.Style
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.markermap.R
import com.example.markermap.screens.bottomNavigationScreens.HomeScreen
import com.example.markermap.screens.bottomNavigationScreens.MapScreen
import com.example.markermap.screens.bottomNavigationScreens.SettingsScreen
import com.google.android.gms.maps.model.Circle

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val filledIcon: Int,
    val outlinedIcon: Int
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        filledIcon = R.drawable.filled_home,
        outlinedIcon = R.drawable.outline_home
    )

    object Profile : BottomBarScreen(
        route = "map",
        title = "Map",
        filledIcon = R.drawable.filled_map,
        outlinedIcon = R.drawable.outline_map
    )

    object Settings : BottomBarScreen(
        route = "settings",
        title = "Settings",
        filledIcon = R.drawable.filled_settings,
        outlinedIcon = R.drawable.outline_settings
    )
}

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.Profile.route) {
            MapScreen()
        }
        composable(route = BottomBarScreen.Settings.route) {
            SettingsScreen()
        }
    }
}

@Composable
fun AppMain() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) { innerPadding ->
        // Apply the padding globally to the whole BottomNavScreensController
        Box(modifier = Modifier.padding(innerPadding)) {
            BottomNavGraph(navController = navController)
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Profile,
        BottomBarScreen.Settings,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Divider()
    Row(
        modifier = Modifier
            .padding(start = 0.dp, end = 0.dp, top = 2.5.dp, bottom = 0.dp)
            .background(Color.Transparent)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController,
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

    val background = if (selected) MaterialTheme.colorScheme.primary.copy(alpha = 0.25f) else Color.Transparent

    val contentColor = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primary.copy(alpha = 0.35f)

    val fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal

    Box(
        modifier = Modifier
            .height(70.dp)
            .clip(CircleShape)
            .clickable(onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            }),
    ) {
        Column (
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top = 12.dp, bottom = 8.dp)
                .scale(0.95f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                painter = painterResource(id = if (selected) screen.filledIcon else screen.outlinedIcon),
                contentDescription = "icon",
                tint = contentColor,
            )
                Text(
                    text = screen.title,
                    color = contentColor,
                    fontWeight = fontWeight
                )
        }
    }
}