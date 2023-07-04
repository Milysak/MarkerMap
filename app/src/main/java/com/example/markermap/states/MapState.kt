package com.example.markermap.states

import com.example.markermap.styles.DarkMapStyle
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.MapProperties

data class MapState(
    val properties: MapProperties = MapProperties(minZoomPreference = 10F),
    val isFalloutMap: Boolean = false
)