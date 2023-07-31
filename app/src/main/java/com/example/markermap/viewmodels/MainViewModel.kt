package com.example.markermap.viewmodels

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val homeViewModel = HomeViewModel()
    val mapViewModel = MapViewModel()
    val settingsViewModel = SettingsViewModel()
}