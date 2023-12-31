package com.example.markermap.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {

    val componentsWidth = 0.85f

    var currentNickname by mutableStateOf("")

    var currentUsername by mutableStateOf("")

    var currentPassword by mutableStateOf("")

    var confirmCurrentPassword by mutableStateOf("")

}