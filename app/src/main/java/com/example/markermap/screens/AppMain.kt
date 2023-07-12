package com.example.markermap.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.*
import androidx.compose.ui.platform.LocalDensity
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
    val outlinedIcon: Int,
) {
    object Map : BottomBarScreen(
        route = "map",
        title = "Map",
        filledIcon = R.drawable.world_filled,
        outlinedIcon = R.drawable.world_outlined
    )

    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        filledIcon = R.drawable.cards_filled,
        outlinedIcon = R.drawable.cards_outlined
    )

    object Messages : BottomBarScreen(
        route = "messages",
        title = "Messages",
        filledIcon = R.drawable.message_filled,
        outlinedIcon = R.drawable.message_outlined
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
        composable(route = BottomBarScreen.Messages.route) {
            MessagesScreen()
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
    val density = LocalDensity.current.density

    val screens = listOf(
        BottomBarScreen.Map,
        BottomBarScreen.Home,
        BottomBarScreen.Messages,
        BottomBarScreen.Rankings,
        BottomBarScreen.Settings,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    var offSet by remember { mutableStateOf(-100.0f) }
    val offSetX by animateFloatAsState(
        targetValue = offSet,
        animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
    )

    Column {

        Row(
            modifier = Modifier
                .background(
                    createGradientBrush(
                        listOf(
                            MaterialTheme.colorScheme.primary.copy(alpha = 0.125f),
                            MaterialTheme.colorScheme.background
                        )
                    )
                )
                .fillMaxWidth()
                .height(3.dp)
        ) {

            /*Box(modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .clip(CircleShape)
            .size(offSetX.dp, 3.dp)
            .offset(offSetX.dp, 0.dp)
        ) {  }*/

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
                val selected =
                    currentDestination?.hierarchy?.any { it.route == screen.route } == true

                val contentColor by animateColorAsState(
                    targetValue = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground.copy(
                        alpha = 0.55f
                    ),
                    animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
                )

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
                    Column(
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
                            modifier = Modifier
                                .onGloballyPositioned { coords ->
                                    if (selected) {
                                        //offSet = coords.positionInRoot().x / density + coords.size.width / density / 2
                                        offSet = coords.positionInRoot().x + coords.size.width / 2
                                    }
                                }
                        )
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
        ) {

            /*Box(modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .clip(CircleShape)
            .size(offSetX.dp, 3.dp)
            .offset(offSetX.dp, 0.dp)
        ) {  }*/

            Layout(content = {
                Box(
                    modifier = Modifier
                        .background(
                            createGradientBrush(
                                listOf(
                                    MaterialTheme.colorScheme.background,
                                    MaterialTheme.colorScheme.primary
                                ), false
                            )
                        )
                        .clip(CircleShape)
                        .size(35.dp, 2.dp)
                )
                Box(
                    modifier = Modifier
                        .background(
                            createGradientBrush(
                                listOf(
                                    MaterialTheme.colorScheme.primary,
                                    MaterialTheme.colorScheme.background
                                ), false
                            )
                        )
                        .clip(CircleShape)
                        .size(35.dp, 2.dp)
                )
            }
            ) { measurables, constrainsts ->
                val indicator1 = measurables[0].measure(constrainsts)
                val indicator2 = measurables[1].measure(constrainsts)

                layout(constrainsts.maxWidth, constrainsts.maxHeight) {
                    indicator1.place(offSetX.toInt() - 105, 0)
                    indicator2.place(offSetX.toInt(), 0)
                }
            }

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

    //val contentColor = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground.copy(alpha = 0.55f)

    val contentColor by animateColorAsState(
        targetValue = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground.copy(alpha = 0.55f),
        animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
    )

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
                tint = contentColor
            )

            /*Text(
                text = screen.title,
                color = contentColor,
                fontWeight = fontWeight
            )*/
        }
    }
}