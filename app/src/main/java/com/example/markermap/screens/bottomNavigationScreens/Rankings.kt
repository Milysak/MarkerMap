package com.example.markermap.screens.bottomNavigationScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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
                Text(text = "Top 10 Users",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 25.sp,
                modifier = Modifier
                    .padding(top = 12.5.dp, bottom = 12.5.dp))
                Row(
                    modifier = Modifier
                        .background(
                            createGradientBrush(
                                listOf(MaterialTheme.colorScheme.background,
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
                    .padding(10.dp, 10.dp, 10.dp, 10.dp),
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

                for (n in 1..10) {
                    RankingItemCard(position = n, name = namesList[n - 1])
                }
            }
        }
    }
}

@Composable
fun RankingItemCard(position: Int, name: String) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 5.dp, bottom = 5.dp),
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