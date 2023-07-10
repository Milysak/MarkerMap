package com.example.markermap.data

import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun loginUser(email: String, password: String)
    fun signUpUser(nickname: String, email: String, password: String, confirmPassword: String)
}