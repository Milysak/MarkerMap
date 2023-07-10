package com.example.markermap.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.markermap.R
import com.example.markermap.screens.bottomNavigationScreens.*
import com.example.markermap.viewmodels.HomeViewModel
import com.example.markermap.viewmodels.MapViewModel

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val filledIcon: Int,
    val outlinedIcon: Int
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        filledIcon = R.drawable.rectangle_list_filled,
        outlinedIcon = R.drawable.rectangle_list_outlined
    )

    object Map : BottomBarScreen(
        route = "map",
        title = "Map",
        filledIcon = R.drawable.world_filled,
        outlinedIcon = R.drawable.world_outlined
    )

    object Rankings : BottomBarScreen(
        route = "rankings",
        title = "Rankings",
        filledIcon = R.drawable.badge_filled,
        outlinedIcon = R.drawable.badge_outlined
    )

    object Settings : BottomBarScreen(
        route = "settings",
        title = "Settings",
        filledIcon = R.drawable.user_filled,
        outlinedIcon = R.drawable.user_outlined
    )
}

@Composable
fun BottomNavGraph(navController: NavHostController) {
    val homeViewModel: HomeViewModel = viewModel()
    val mapViewModel: MapViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Map.route
    ) {
        composable(route = BottomBarScreen.Map.route) {
            MapScreen(mapViewModel)
        }
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(homeViewModel)
        }
        composable(route = BottomBarScreen.Rankings.route) {
            RankingsScreen()
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
        BottomBarScreen.Map,
        BottomBarScreen.Home,
        BottomBarScreen.Rankings,
        BottomBarScreen.Settings,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Row(modifier = Modifier
        .background(createGradientBrush(listOf(MaterialTheme.colorScheme.primary.copy(alpha = 0.125f), MaterialTheme.colorScheme.background)))
        .fillMaxWidth()
        .height(3.dp)
    ) {

    }

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
fun AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

    val background = if (selected) MaterialTheme.colorScheme.primary.copy(alpha = 0.25f) else Color.Transparent

    val contentColor = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground.copy(alpha = 0.55f)

    val fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal

    val zoom = if (selected) 1.15f else 1f

    Box(
        modifier = Modifier
            .height(55.dp)
            .clip(CircleShape)
            .clickable(interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = {
                    if (currentDestination?.hierarchy?.any { it.route == screen.route } == false) {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.findStartDestination().id)
                            launchSingleTop = true
                        }
                    }
                }
            ),
    ) {
        Column (
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 15.dp, bottom = 0.dp)
                .scale(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Icon(
                painter = painterResource(id = if (selected) screen.filledIcon else screen.outlinedIcon),
                contentDescription = "icon",
                tint = contentColor,
            )

            /*Text(
                text = screen.title,
                color = contentColor,
                fontWeight = fontWeight
            )*/
        }
    }
}