package com.example.markermap.screens.bottomNavigationScreens

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.markermap.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessagesScreen() {
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.menu_burger),
                contentDescription = "Icon Menu",
                modifier = Modifier
                    .size(25.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(0.dp, Color.Transparent)
                    .padding(start = 15.dp)
                    .height(50.dp),
                value = text,
                shape = RoundedCornerShape(30.dp),
                placeholder = { Text(text = "Search...") },
                onValueChange = {
                    text = it
                },
                label = null,
                leadingIcon = {
                    Icon(
                        modifier = Modifier
                            .size(16.dp),
                        painter = painterResource(id = R.drawable.search_outlined),
                        contentDescription = "AccountBox Icon"
                    )
                },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
                    focusedContainerColor = MaterialTheme.colorScheme.secondary,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                )
            )
        }

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(5.dp)
        ) {
            for (i in 1..10) ContactField()
        }
    }
}

@Composable
fun ContactField() {
    Box(
        modifier = Modifier
            .padding(horizontal = 15.dp)
    ) {
        Divider()

        Row(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(
                        createGradientBrush(
                            listOf(
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.secondary
                            )
                        )
                    ),
            ) {
                Image(
                    modifier = Modifier
                        .padding(1.0.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.keys_photo),
                    contentDescription = "Profile Image",
                    contentScale = ContentScale.Crop,
                )
            }

            Column(modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .padding(start = 10.dp)
            ) {
                Text(
                    text = "Nickname",
                    fontSize = 20.sp,
                )

                Text(
                    text = "Here, this is a message...",
                    fontStyle = FontStyle.Italic,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
                )
            }
        }

        Divider()
    }
}

@Composable
@Preview
fun MessagesScreenPreview() {
    MessagesScreen()
}