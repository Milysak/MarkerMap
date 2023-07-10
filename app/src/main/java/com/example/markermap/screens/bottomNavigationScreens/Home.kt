package com.example.markermap.screens.bottomNavigationScreens

import android.annotation.SuppressLint
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.markermap.R
import com.example.markermap.data.dataClasses.FlipCardData
import com.example.markermap.viewmodels.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        val scrollState = rememberScrollState(viewModel.scrollProgress)

        Column {
            val listOfCards = listOf(
                FlipCardData(
                title = "Kluczyki",
                distance = 0.4,
                description = "She exposed painted fifteen are noisier mistake led waiting. Surprise not wandered speedily husbands although yet end. Are court tiled cease young built fat one man taken. We highest ye friends is exposed equally in. Ignorant had too strictly followed. Astonished as travelling assistance or unreserved oh pianoforte ye. Five with seen put need tore add neat. Bringing it is he returned received raptures."
            ),
                FlipCardData(title = "Torba",
                distance = 1.7,
                description = "She exposed painted fifteen are noisier mistake led waiting. Surprise not wandered speedily husbands although yet end. Are court tiled cease young built fat one man taken. We highest ye friends is exposed equally in. Ignorant had too strictly followed. Astonished as travelling assistance or unreserved oh pianoforte ye. Five with seen put need tore add neat. Bringing it is he returned received raptures."
            ),
                FlipCardData(title = "Portfel",
                distance = 5.4,
                description = "She exposed painted fifteen are noisier mistake led waiting. Surprise not wandered speedily husbands although yet end. Are court tiled cease young built fat one man taken. We highest ye friends is exposed equally in. Ignorant had too strictly followed. Astonished as travelling assistance or unreserved oh pianoforte ye. Five with seen put need tore add neat. Bringing it is he returned received raptures."
            ),
                FlipCardData(title = "Torebka",
                distance = 7.5,
                description = "She exposed painted fifteen are noisier mistake led waiting. Surprise not wandered speedily husbands although yet end. Are court tiled cease young built fat one man taken. We highest ye friends is exposed equally in. Ignorant had too strictly followed. Astonished as travelling assistance or unreserved oh pianoforte ye. Five with seen put need tore add neat. Bringing it is he returned received raptures."
            ),
                FlipCardData(title = "Piłka",
                distance = 11.9,
                description = "She exposed painted fifteen are noisier mistake led waiting. Surprise not wandered speedily husbands although yet end. Are court tiled cease young built fat one man taken. We highest ye friends is exposed equally in. Ignorant had too strictly followed. Astonished as travelling assistance or unreserved oh pianoforte ye. Five with seen put need tore add neat. Bringing it is he returned received raptures."
            ),
                FlipCardData(
                    title = "Kluczyki",
                    distance = 3.4,
                    description = "She exposed painted fifteen are noisier mistake led waiting. Surprise not wandered speedily husbands although yet end. Are court tiled cease young built fat one man taken. We highest ye friends is exposed equally in. Ignorant had too strictly followed. Astonished as travelling assistance or unreserved oh pianoforte ye. Five with seen put need tore add neat. Bringing it is he returned received raptures."
                ),
                FlipCardData(title = "Torba",
                    distance = 18.7,
                    description = "She exposed painted fifteen are noisier mistake led waiting. Surprise not wandered speedily husbands although yet end. Are court tiled cease young built fat one man taken. We highest ye friends is exposed equally in. Ignorant had too strictly followed. Astonished as travelling assistance or unreserved oh pianoforte ye. Five with seen put need tore add neat. Bringing it is he returned received raptures."
                ),
                FlipCardData(title = "Portfel",
                    distance = 1.4,
                    description = "She exposed painted fifteen are noisier mistake led waiting. Surprise not wandered speedily husbands although yet end. Are court tiled cease young built fat one man taken. We highest ye friends is exposed equally in. Ignorant had too strictly followed. Astonished as travelling assistance or unreserved oh pianoforte ye. Five with seen put need tore add neat. Bringing it is he returned received raptures."
                ),
                FlipCardData(title = "Torebka",
                    distance = 0.5,
                    description = "She exposed painted fifteen are noisier mistake led waiting. Surprise not wandered speedily husbands although yet end. Are court tiled cease young built fat one man taken. We highest ye friends is exposed equally in. Ignorant had too strictly followed. Astonished as travelling assistance or unreserved oh pianoforte ye. Five with seen put need tore add neat. Bringing it is he returned received raptures."
                ),
                FlipCardData(title = "Piłka",
                    distance = 4.9,
                    description = "She exposed painted fifteen are noisier mistake led waiting. Surprise not wandered speedily husbands although yet end. Are court tiled cease young built fat one man taken. We highest ye friends is exposed equally in. Ignorant had too strictly followed. Astonished as travelling assistance or unreserved oh pianoforte ye. Five with seen put need tore add neat. Bringing it is he returned received raptures."
                ),
            ).sortedBy { it.distance }

            // TOP BAR
            Column(
                modifier = Modifier
                    .padding(start = 0.dp, end = 0.dp, top = 0.dp, bottom = 0.dp)
                    .background(Color.Transparent)
                    .fillMaxWidth()
                    .height(70.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                ) {
                    // Multi Toggle Bar
                    var currentSelection by remember { mutableStateOf("nearest") }

                    MultiToggleButton(
                        currentSelection = currentSelection,
                        toggleStates = listOf("nearest", "popular"),
                        toggleInactiveIcons = listOf(R.drawable.road_outlined, R.drawable.fire_outlined),
                        toggleActiveIcons = listOf(R.drawable.road_filled, R.drawable.fire_filled),
                        onToggleChange = { currentSelection = it }
                    )
                }

                Row(
                    modifier = Modifier
                        .background(
                            createGradientBrush(
                                listOf(
                                    MaterialTheme.colorScheme.background,
                                    MaterialTheme.colorScheme.primary.copy(
                                        alpha = 0.125f
                                    )
                                )
                            )
                        )
                        .fillMaxWidth()
                        .height(3.dp)
                ) {

                }
            }

            // LIST OF CARDS
            /*Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
                    .padding(0.dp, 10.dp, 0.dp, 10.dp),
            ) {
                if (scrollState.isScrollInProgress) {
                    viewModel.scrollProgress = scrollState.value
                }

                for (item in listOfCards) {
                    FlipCard(title = item.title, distance = item.distance, description = item.description)
                }
            }*/

            // HORIZONTAL PAGER OF CARDS
            CustomHorizontalPager(listOfCards)
        }
    }
}

@Composable
fun MultiToggleButton(
    currentSelection: String,
    toggleStates: List<String>,
    toggleInactiveIcons: List<Int>,
    toggleActiveIcons: List<Int>,
    onToggleChange: (String) -> Unit
) {
    val selectedTint = MaterialTheme.colorScheme.primary
    val unselectedTint = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)

    Row(modifier = Modifier
        .height(IntrinsicSize.Min)
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        toggleStates.forEachIndexed { index, toggleState ->
            val isSelected = currentSelection.lowercase() == toggleState.lowercase()
            val color = if (isSelected) selectedTint else unselectedTint
            val textBold = if (isSelected) FontWeight.Bold else FontWeight.Normal
            val icon = if (isSelected) toggleActiveIcons[index] else toggleInactiveIcons[index]

            Row(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .toggleable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        value = isSelected,
                        enabled = true,
                        onValueChange = { selected ->
                            if (selected) {
                                onToggleChange(toggleState)
                            }
                        }
                    )
            ) {
                Icon(painter = painterResource(id = icon),
                    contentDescription = "Icon of Toggle",
                    tint = color
                )
                Text(toggleState.uppercase(),
                    color = color,
                    modifier = Modifier.padding(4.dp),
                    fontWeight = textBold
                )
            }

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomHorizontalPager(listOfCards: List<FlipCardData>) {
    val pagerState = rememberPagerState()

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HorizontalPager(
            modifier = Modifier
                .fillMaxHeight(0.7f)
                .fillMaxWidth(),
            pageCount = listOfCards.size,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 50.dp),
            pageSpacing = 0.dp
        ) { page ->

            val pageOffset = (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction

            val cardSize by animateFloatAsState(
                targetValue = if (page == pagerState.currentPage) 1f else 0.9f,
                animationSpec = tween(durationMillis = 300)
            )

            val cardAlpha by animateFloatAsState(
                targetValue = if (page == pagerState.currentPage) 1f else 0.5f,
                animationSpec = tween(durationMillis = 300)
            )

            Box(modifier = Modifier
                .scale(cardSize)
                .alpha(cardAlpha),
            ) {
                FlipCard(
                    title = listOfCards[page].title,
                    distance = listOfCards[page].distance,
                    description = listOfCards[page].description,
                )
            }
        }

        Row(
            modifier = Modifier
                .height(40.dp)
                .padding(top = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(listOfCards.size) { it ->
                val color = if (pagerState.currentPage == it) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)

                Box(modifier = Modifier
                    .padding(3.5.dp)
                    .clip(CircleShape)
                    .size(6.dp)
                    .background(color))
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FrontCard(title: String, distance: Double) {
    var distanceColor by remember { mutableStateOf(Color(0xFF00C853)) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary,
        ),
    ) {
        val pagerState = rememberPagerState()
        val listOfImages = listOf(R.drawable.backpack_photo, R.drawable.ball_photo, R.drawable.keys_photo)

        Column(modifier = Modifier
            .fillMaxHeight()) {
            Row(modifier = Modifier
                .fillMaxHeight(0.7f)
                ) {

                HorizontalPager(
                    modifier = Modifier
                        .fillMaxHeight(1f)
                        .fillMaxWidth(),
                    pageCount = listOfImages.size,
                    state = pagerState,
                    contentPadding = PaddingValues(horizontal = 0.dp, vertical = 0.dp),
                    pageSpacing = 0.dp
                ) { page ->
                    Image(painter = painterResource(id = listOfImages[page]),
                        alpha = 1.0F,
                        contentDescription = "photos of thing",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                    )
                }
            }

            Row(
                modifier = Modifier
                    .height(40.dp)
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(listOfImages.size) { it ->
                    val color = if (pagerState.currentPage == it) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)

                    Box(modifier = Modifier
                        .padding(3.5.dp)
                        .clip(CircleShape)
                        .size(6.dp)
                        .background(color))
                }
            }

            Spacer(Modifier.weight(1f))

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = title,
                    modifier = Modifier.padding(15.dp, 15.dp, 2.5.dp, 15.dp),
                    fontSize = 20.sp
                )
                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = "Navigation Icon",
                )
                Spacer(Modifier.weight(1f))
                Text(
                    text = "$distance km",
                    modifier = Modifier.padding(15.dp, 15.dp, 15.dp, 15.dp),
                    fontSize = 20.sp,
                    color = distanceColor,
                )

                distanceColor = when (distance) {
                    in 0.1..5.0 -> Color(0xFF00C853)
                    in 5.1..10.0 -> Color(0xFFFFC107)
                    else -> Color(0xFFF44336)
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .clip(RectangleShape)
                    .background(
                        createGradientBrush(
                            listOf(
                                MaterialTheme.colorScheme.secondary,
                                MaterialTheme.colorScheme.primary
                            ), false
                        )
                    )
            )
        }
    }
}

@Composable
fun BackCard(distance: Double, text: String) {
    var distanceColor by remember { mutableStateOf(Color(0xFF00C853)) }

    distanceColor = when (distance) {
        in 0.1..5.0 -> Color(0xFF00C853)
        in 5.1..10.0 -> Color(0xFFFFC107)
        else -> Color(0xFFF44336)
    }

    Card(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary,
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            ) {
            Text(text = text,
                modifier = Modifier
                    .padding(15.dp, 15.dp, 15.dp, 5.dp)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            )
            Spacer(Modifier.weight(1f))
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                ExtendedFloatingActionButton(
                    onClick = { /* TODO */ },
                    modifier = Modifier
                        .height(50.dp)
                        .padding(15.dp, 10.dp),
                    shape = RoundedCornerShape(10.dp),
                    containerColor = MaterialTheme.colorScheme.primary
                ) {
                    Text(
                        modifier = Modifier
                            .padding(0.dp),
                        text = "Znalazłem!",
                        fontSize = 14.sp)
                }
                Spacer(Modifier.weight(1f))
                Text(
                    text = "$distance km",
                    modifier = Modifier.padding(15.dp, 15.dp, 15.dp, 15.dp),
                    fontSize = 20.sp,
                    color = distanceColor,
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .clip(RectangleShape)
                    .background(
                        createGradientBrush(
                            listOf(
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.secondary
                            ), false
                        )
                    )
            )
        }
    }
}
@Composable
fun FrontMiniCard(title: String, distance: Double) {
    var distanceColor by remember { mutableStateOf(Color(0xFF00C853)) }

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary,
        ),
    ) {
        Column {
            Row(modifier = Modifier
                .height(125.dp)
                .background(
                    createGradientBrush(
                        listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.secondary
                        )
                    )
                )) {
                Image(painter = painterResource(id = R.drawable.backpack_photo),
                    alpha = 1.0F,
                    contentDescription = "photos of thing",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(end = 1.dp)
                        .background(MaterialTheme.colorScheme.primary)
                )

                Column() {
                    Image(painter = painterResource(id = R.drawable.ball_photo),
                        alpha = 1.0F,
                        contentDescription = "photos of thing",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxHeight(0.5f)
                            .fillMaxWidth()
                            .padding(bottom = 1.dp, start = 1.dp)
                            .background(MaterialTheme.colorScheme.primary)
                    )
                    Image(painter = painterResource(id = R.drawable.keys_photo),
                        alpha = 1.0F,
                        contentDescription = "photos of thing",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(top = 1.dp, start = 1.dp)
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.primary)
                    )
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = title,
                    modifier = Modifier.padding(15.dp, 15.dp, 2.5.dp, 15.dp),
                    fontSize = 20.sp
                )
                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = "Navigation Icon",
                )
                Spacer(Modifier.weight(1f))
                Text(
                    text = "$distance km",
                    modifier = Modifier.padding(15.dp, 15.dp, 15.dp, 15.dp),
                    fontSize = 20.sp,
                    color = distanceColor,
                )

                distanceColor = when (distance) {
                    in 0.1..5.0 -> Color(0xFF00C853)
                    in 5.1..10.0 -> Color(0xFFFFC107)
                    else -> Color(0xFFF44336)
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .clip(RectangleShape)
                    .background(
                        createGradientBrush(
                            listOf(
                                MaterialTheme.colorScheme.secondary,
                                MaterialTheme.colorScheme.primary
                            ), false
                        )
                    )
            )
        }
    }
}

@Composable
fun BackMiniCard(distance: Double, text: String) {
    var distanceColor by remember { mutableStateOf(Color(0xFF00C853)) }

    distanceColor = when (distance) {
        in 0.1..5.0 -> Color(0xFF00C853)
        in 5.1..10.0 -> Color(0xFFFFC107)
        else -> Color(0xFFF44336)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary,
        ),
    ) {
        Column {
            Text(text = text,
                modifier = Modifier
                    .height(125.dp)
                    .padding(15.dp, 15.dp, 15.dp, 5.dp)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                ExtendedFloatingActionButton(
                    onClick = { /* TODO */ },
                    modifier = Modifier
                        .height(50.dp)
                        .padding(15.dp, 10.dp),
                    shape = RoundedCornerShape(10.dp),
                    containerColor = MaterialTheme.colorScheme.primary
                ) {
                    Text(
                        modifier = Modifier
                            .padding(0.dp),
                        text = "Znalazłem!",
                        fontSize = 14.sp)
                }
                Spacer(Modifier.weight(1f))
                Text(
                    text = "$distance km",
                    modifier = Modifier.padding(15.dp, 15.dp, 15.dp, 15.dp),
                    fontSize = 20.sp,
                    color = distanceColor,
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .clip(RectangleShape)
                    .background(
                        createGradientBrush(
                            listOf(
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.secondary
                            ), false
                        )
                    )
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomCard(title: String, distance: Double) {
    var expanded by remember { mutableStateOf (false) }
    var icon by remember { mutableStateOf(Icons.Default.KeyboardArrowDown) }
    var distanceColor by remember { mutableStateOf(Color(0xFF00C853)) }

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp, 7.5.dp, 15.dp, 7.5.dp)
    ) {
        Column {
            Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                alpha = 0.0F,
                contentDescription = "photos of thing",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(125.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable { expanded = !expanded }
            ) {
                Text(
                    text = title,
                    modifier = Modifier.padding(15.dp, 15.dp, 2.5.dp, 15.dp),
                    fontSize = 20.sp
                )
                Icon(
                    imageVector = icon,
                    contentDescription = "Navigation Icon",
                )
                Spacer(Modifier.weight(1f))
                Text(
                    text = "$distance km",
                    modifier = Modifier.padding(15.dp, 15.dp, 15.dp, 15.dp),
                    fontSize = 20.sp,
                    color = distanceColor,
                )

                distanceColor = when (distance) {
                    in 0.1..5.0 -> Color(0xFF00C853)
                    in 5.1..10.0 -> Color(0xFFFFC107)
                    else -> Color(0xFFF44336)
                }
            }
            
            if (expanded) {
                icon = Icons.Default.KeyboardArrowUp

                Divider(color = MaterialTheme.colorScheme.secondary)
                Text(
                    text = "Content Sample for Display on Expansion of Card. Content Sample for Display on Expansion of Card.",
                    modifier = Modifier.padding(15.dp),
                    fontSize = 17.5.sp
                )

                ExtendedFloatingActionButton(
                    onClick = { /* TODO */ },
                    modifier = Modifier
                        .height(75.dp)
                        .padding(15.dp),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text(
                        modifier = Modifier
                            .padding(0.dp),
                        text = "Znalazłem!",
                        fontSize = 14.sp)
                }

            } else {
                icon = Icons.Default.KeyboardArrowDown
            }
        }
    }
}

@SuppressLint("RememberReturnType", "UnrememberedMutableState")
@Composable
fun FlipCard(title: String, distance: Double, description: String) {
    var rotated by remember { mutableStateOf(false) }

    val rotation by animateFloatAsState(
        targetValue = if (rotated) 180f else 0f,
        animationSpec = tween(400, easing = FastOutSlowInEasing)
    )

    val animateFront by animateFloatAsState(
        targetValue = if (!rotated) 1f else 0f,
        animationSpec = tween(400, easing = FastOutSlowInEasing)
    )

    val animateBack by animateFloatAsState(
        targetValue = if (rotated) 1f else 0f,
        animationSpec = tween(400, easing = FastOutSlowInEasing)
    )

    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            Modifier
                .fillMaxSize()
                .graphicsLayer {
                    rotationY = rotation
                    cameraDistance = 8 * density
                }
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = { rotated = !rotated }
                ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondary,
            ),
        ) {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        alpha = if (rotated) animateBack else animateFront
                        rotationY = rotation
                    }
                ) {
                    if (rotated) BackCard(distance = distance,
                        text = description) else FrontCard(
                        title = title,
                        distance = distance
                    )
                }
            }
        }
    }
}

fun createGradientBrush(
    colors: List<Color>,
    isVertical: Boolean = true
): Brush {

    val endOffset = if (isVertical) {
        Offset(0f, Float.POSITIVE_INFINITY)
    } else {
        Offset(Float.POSITIVE_INFINITY, 0f)
    }

    return Brush.linearGradient(
        colors = colors,
        start = Offset(0f, 0f),
        end = endOffset,
        tileMode = TileMode.Clamp
    )
}