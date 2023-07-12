package com.example.markermap.screens.bottomNavigationScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.markermap.R

@Composable
fun SettingsScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 0.dp, end = 0.dp, top = 0.dp, bottom = 0.dp)
                    .background(Color.Transparent)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(modifier = Modifier
                    .height(55.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        modifier = Modifier
                            .size(24.dp)
                            .padding(end = 5.dp),
                        painter = painterResource(id = R.drawable.user_filled),
                        contentDescription = "User Icon",
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "USERNAME",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Spacer(Modifier.weight(1f))

                    OutlinedButton(
                        onClick = { /* TODO */ },
                        modifier = Modifier
                            .width(100.dp)
                            .height(35.dp),
                        shape = RoundedCornerShape(7.5.dp)
                    ) {
                        Text(text = "Log Out", fontSize = 15.sp)
                    }
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
                ) {  }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Box(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .background(
                        createGradientBrush(listOf(MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.secondary))
                    ),
            ) {
                Image(
                    modifier = Modifier
                        .padding(5.5.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.keys_photo),
                    contentDescription = "Profile Image",
                    contentScale = ContentScale.Crop,
                )
            }



        }
    }
}

@Composable
@Preview
fun SettingsScreenPreview() {
    SettingsScreen()
}