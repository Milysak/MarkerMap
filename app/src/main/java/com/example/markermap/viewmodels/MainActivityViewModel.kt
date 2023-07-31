package com.example.markermap.viewmodels

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await
import java.util.regex.Pattern
import kotlin.coroutines.Continuation

class MainActivityViewModel : ViewModel() {

    private val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})";

    val loginViewModel = LoginViewModel()
    val signUpViewModel = SignUpViewModel()

    private val auth: FirebaseAuth = Firebase.auth

    private var loginState: Boolean = false

    @OptIn(DelicateCoroutinesApi::class)
    suspend fun login(email: String, password: String) : Boolean {
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            result.user != null
        } catch (e: Exception) {
            false
        }
    }

    suspend fun register(email: String, password: String, confirmPassword: String) : Boolean {
            return try {
                auth.createUserWithEmailAndPassword(email, password).await()
                true
            } catch (e: Exception) {
                false
            }
    }

    private fun validateEmail(email: String) : Boolean {
        return emailRegex.toRegex().matches(email);
    }

    private fun validatePassword(password: String) : Boolean {
        return password.length > 6
    }

    private fun validatePassword(password: String, confirmPassword: String) : Boolean {
        return password == confirmPassword && validatePassword(password) && validatePassword(confirmPassword)
    }

}