package com.example.markermap.screens.bottomNavigationScreens

import android.content.Intent
import android.content.res.Resources.Theme
import android.graphics.Camera
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
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
import androidx.lifecycle.ViewModel
import com.example.markermap.AppActivity
import com.example.markermap.viewmodels.MapViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen(
    viewModel: MapViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ },
                    containerColor = MaterialTheme.colorScheme.primary
                ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add New Thing"
                )
            }
        },
        topBar = {
            Row(horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, end = 15.dp)) {

                FloatingActionButton(onClick = { /*TODO*/ },
                    containerColor = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .width(70.dp)
                        .height(45.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "Add New Thing"
                    )
                }

                Spacer(modifier = Modifier.width(5.dp))
                
                FloatingActionButton(onClick = { /*TODO*/ },
                    containerColor = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .width(70.dp)
                        .height(45.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Star,
                        contentDescription = "Add New Thing"
                    )
                }

                Spacer(modifier = Modifier.width(5.dp))

                FloatingActionButton(onClick = { /*TODO*/ },
                    containerColor = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .width(70.dp)
                        .height(45.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Menu,
                        contentDescription = "Add New Thing"
                    )
                }
            }
        }
    ) {
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(LatLng(50.262606656386104, 19.03967912803772), 12f)
        }
        GoogleMap(
            cameraPositionState = cameraPositionState,
            modifier = Modifier
                .fillMaxSize(),
            properties = viewModel.state.properties,
            uiSettings = MapUiSettings(zoomControlsEnabled = false)
        ) {
            if (isSystemInDarkTheme()) {
                viewModel.setDarkMapTheme()
            } else {
                viewModel.setLightMapTheme()
            }
        }
    }
}

@Composable
@Preview
fun ProfileScreenPreview() {
    MapScreen()
}