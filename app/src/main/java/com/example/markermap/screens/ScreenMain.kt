package com.example.markermap.screens

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.markermap.app.Routes
import com.example.markermap.viewmodels.LoginViewModel
import com.example.markermap.viewmodels.MainActivityViewModel
import com.example.markermap.viewmodels.SignUpViewModel

@Composable
fun ScreenMain(){
    val navController = rememberNavController()
    val mainActivityViewModel: MainActivityViewModel = viewModel()

    NavHost(navController = navController, startDestination = Routes.Login.route, modifier = Modifier.background(MaterialTheme.colorScheme.background)) {

        composable(Routes.Login.route) {
            LoginPage(navController = navController, vm = mainActivityViewModel)
        }

        composable(Routes.SignUp.route) {
            SignUp(navController = navController, vm = mainActivityViewModel)
        }
    }
}