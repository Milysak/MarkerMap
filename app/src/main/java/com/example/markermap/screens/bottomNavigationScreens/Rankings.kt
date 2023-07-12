package com.example.markermap.screens.bottomNavigationScreens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.markermap.R

@Composable
fun RankingsScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column() {

            Column(
                modifier = Modifier
                    .padding(start = 0.dp, end = 0.dp, top = 0.dp, bottom = 0.dp)
                    .background(Color.Transparent)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var currentSelection by remember { mutableStateOf("week") }
                MultiToggleButton(currentSelection = currentSelection, toggleStates = listOf("week", "month", "year"), onToggleChange = { currentSelection = it })

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

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(10.dp, 15.dp, 10.dp, 15.dp),
            ) {
                val namesList = listOf(
                    "Danny",
                    "Eric",
                    "Stive",
                    "Mark",
                    "Marry",
                    "Edd",
                    "Juliet",
                    "Elon",
                    "David",
                    "Sophany"
                )

                for (n in 0..99) {
                    RankingItemCard(position = n + 1, name = namesList[n % 10])
                }
            }
        }
    }
}

@Composable
fun RankingItemCard(position: Int, name: String) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 0.dp, bottom = 8.dp, start = 5.dp, end = 5.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary,
        ),
    ) {
        val color = when(position) {
            1 -> Color(0xFF00C853).copy(alpha = 0.5f)
            2 -> Color(0xFFFFC107).copy(alpha = 0.5f)
            3 -> Color(0xFFF44336).copy(alpha = 0.5f)
            else -> MaterialTheme.colorScheme.secondary
        }

        Row(modifier = Modifier
            .background(
                createGradientBrush(
                    listOf(
                        color,
                        MaterialTheme.colorScheme.background.copy(alpha = 1f)
                    ), false
                )
            )
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(modifier = Modifier.padding(start = 15.dp), painter = painterResource(id = R.drawable.user_filled), contentDescription = "User Icon")
            Text(
                text = "$position. $name",
                modifier = Modifier.padding(15.dp, 15.dp, 2.5.dp, 15.dp),
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun MultiToggleButton(
    currentSelection: String,
    toggleStates: List<String>,
    onToggleChange: (String) -> Unit
) {
    val selectedTint = MaterialTheme.colorScheme.primary
    val unselectedTint = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)

    Row(modifier = Modifier
        .height(55.dp)
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        toggleStates.forEachIndexed { index, toggleState ->
            val isSelected = currentSelection.lowercase() == toggleState.lowercase()
            val color by animateColorAsState(
                targetValue = if (isSelected) selectedTint else unselectedTint,
                animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
            )
            val textBold = if (isSelected) FontWeight.Bold else FontWeight.Normal

            Row(
                modifier = Modifier
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
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(toggleState.uppercase(),
                    color = color,
                    modifier = Modifier.padding(4.dp),
                    fontWeight = textBold
                )
            }

        }
    }
}