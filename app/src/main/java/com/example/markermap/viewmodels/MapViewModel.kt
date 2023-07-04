package com.example.markermap.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.markermap.states.MapState

class MapViewModel : ViewModel() {
    var state by mutableStateOf(MapState())
}