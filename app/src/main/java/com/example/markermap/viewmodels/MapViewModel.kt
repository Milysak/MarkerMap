package com.example.markermap.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.markermap.states.MapState
import com.example.markermap.styles.DarkMapStyle
import com.example.markermap.styles.LightMapStyle
import com.google.android.gms.maps.model.MapStyleOptions

class MapViewModel : ViewModel() {
    var state by mutableStateOf(MapState())

    val darkMapTheme = MapStyleOptions(DarkMapStyle.json)
    val lightMapTheme = MapStyleOptions(LightMapStyle.json)

    fun setDarkMapTheme() {
        state = state.copy(
            properties = state.properties.copy(
                mapStyleOptions = darkMapTheme
            )
        )
    }

    fun setLightMapTheme(){
        state = state.copy(
            properties = state.properties.copy(
                mapStyleOptions = lightMapTheme
            )
        )
    }
}