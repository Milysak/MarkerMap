package com.example.markermap.screens.bottomNavigationScreens

import android.content.res.Resources.Theme
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.markermap.R
import com.example.markermap.app.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(0.dp, 10.dp, 0.dp, 10.dp),
        ) {
            CustomCard("Zegarek", 3.1)
            CustomCard("Kluczyki", 4.3)
            CustomCard("Biżuteria", 5.0)
            CustomCard("Plecak", 6.8)
            CustomCard("Kluczyki", 11.2)
            CustomCard("Piłka", 23.7)
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
        onClick = { expanded = !expanded },
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
                verticalAlignment = Alignment.CenterVertically
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

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}