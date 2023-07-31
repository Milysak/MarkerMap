package com.example.markermap.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    val componentsWidth = 0.85f

    var currentUsername by mutableStateOf("")

    var currentPassword by mutableStateOf("")

    var isLoading by mutableStateOf(false)
}