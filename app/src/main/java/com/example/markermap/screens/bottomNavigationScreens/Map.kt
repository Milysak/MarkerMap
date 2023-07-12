package com.example.markermap.screens.bottomNavigationScreens

import android.content.Context
import android.graphics.Bitmap
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.example.markermap.R
import com.example.markermap.viewmodels.MapViewModel
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

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
            position = CameraPosition.fromLatLngZoom(LatLng(viewModel.latitude, viewModel.longitude), viewModel.zoom)
        }
        GoogleMap(
            cameraPositionState = cameraPositionState,
            modifier = Modifier
                .fillMaxSize(),
            properties = viewModel.state.properties,
            uiSettings = MapUiSettings(zoomControlsEnabled = false),
        ) {
            if (cameraPositionState.cameraMoveStartedReason == CameraMoveStartedReason.GESTURE) {
                viewModel.latitude = cameraPositionState.position.target.latitude
                viewModel.longitude = cameraPositionState.position.target.longitude
                viewModel.zoom = cameraPositionState.position.zoom
            }

            if (isSystemInDarkTheme()) {
                viewModel.setDarkMapTheme()
            } else {
                viewModel.setLightMapTheme()
            }

            Marker(
                state = MarkerState(
                    LatLng(49.96861722265689, 19.111226003470446),
                ),
                icon = bitmapDescriptor(LocalContext.current, R.drawable.user_filled)
            )

            Marker(
                state = MarkerState(
                    LatLng(50.12381886976235, 18.989313893414902),
                ),
                icon = bitmapDescriptor(LocalContext.current, R.drawable.user_filled)
            )

            Marker(
                state = MarkerState(
                    LatLng(50.25230345189794, 18.958790480737246),
                ),
                icon = bitmapDescriptor(LocalContext.current, R.drawable.user_filled)
            )
        }
    }
}

fun bitmapDescriptor(
    context: Context,
    vectorResId: Int
): BitmapDescriptor? {

    // retrieve the actual drawable
    val drawable = ContextCompat.getDrawable(context, vectorResId) ?: return null
    drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
    val bm = Bitmap.createBitmap(
        drawable.intrinsicWidth,
        drawable.intrinsicHeight,
        Bitmap.Config.ARGB_8888
    )

    // draw it onto the bitmap
    val canvas = android.graphics.Canvas(bm)
    drawable.draw(canvas)
    return BitmapDescriptorFactory.fromBitmap(bm)
}

@Composable
@Preview
fun ProfileScreenPreview() {
    MapScreen()
}