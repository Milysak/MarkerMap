package com.example.markermap.screens

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.markermap.AppActivity
import com.example.markermap.app.Routes
import com.example.markermap.viewmodels.LoginViewModel

@Composable
fun LoginPage(navController: NavController){
    val viewModel: LoginViewModel = viewModel()

    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome Back!", fontSize = 35.sp)

        Spacer(modifier = Modifier.height(40.dp))

        OutlinedTextField(
            value = viewModel.currentUsername,
            shape = RoundedCornerShape(15.dp),
            label = { Text(text = "Username") },
            onValueChange = {
                viewModel.currentUsername = it
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = viewModel.currentPassword,
            shape = RoundedCornerShape(15.dp),
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = {
                viewModel.currentPassword = it
            }
        )

        Spacer(modifier = Modifier.height(50.dp))

        val mContext = LocalContext.current
        ExtendedFloatingActionButton(
            onClick = { mContext.startActivity(Intent(mContext, AppActivity::class.java)) },
            modifier = Modifier
                .width(250.dp)
                .height(50.dp),
            icon = {
                Icon(
                    Icons.Filled.Done,
                    contentDescription = "Favorite"
                )
            },
            text = { Text("Login", fontSize = 20.sp) }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = {
                if (!navController.navigateUp()) {
                    navController.navigate(Routes.SignUp.route)
                }
                      },
            modifier = Modifier
                .width(250.dp)
                .height(50.dp),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(text = "Register", fontSize = 20.sp)
        }
    }
}