package com.example.markermap.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.markermap.R
import com.example.markermap.app.Routes
import com.example.markermap.viewmodels.LoginViewModel
import com.example.markermap.viewmodels.SignUpViewModel

@Composable
fun SignUp(navController: NavController){
    val viewModel: SignUpViewModel = viewModel()

    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Register Here!", fontSize = 35.sp)

        Spacer(modifier = Modifier.height(40.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(0.9f),
            value = viewModel.currentUsername,
            shape = RoundedCornerShape(15.dp),
            label = { Text(text = "Username") },
            onValueChange = {
                viewModel.currentUsername = it
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "AccountBox Icon")
            },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(20.dp))

        var passwordVisibility by remember { mutableStateOf(false) }

        val changeVisibilityIcon = if (passwordVisibility) painterResource(id = R.drawable.eye_show) else painterResource(id = R.drawable.eye_hide)


        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(0.9f),
            value = viewModel.currentPassword,
            shape = RoundedCornerShape(15.dp),
            label = { Text(text = "Password") },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = {
                viewModel.currentPassword = it
            },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(painter = changeVisibilityIcon, contentDescription = "Show/Hide")
                }
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "Lock Icon")
            },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(0.9f),
            value = viewModel.confirmCurrentPassword,
            shape = RoundedCornerShape(15.dp),
            label = { Text(text = "Password") },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = {
                viewModel.confirmCurrentPassword = it
            },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(painter = changeVisibilityIcon, contentDescription = "Show/Hide")
                }
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "Lock Icon")
            },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(50.dp))

        ExtendedFloatingActionButton(
            onClick = { /* Do something! */ },
            modifier = Modifier
                .width(250.dp)
                .height(50.dp),
            icon = {
                Icon(
                    Icons.Filled.Lock,
                    contentDescription = "Favorite"
                )
            },
            text = { Text("Register", fontSize = 20.sp) }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = {
                navController.navigateUp()
                      },
            modifier = Modifier
                .width(250.dp)
                .height(50.dp),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(text = "Login", fontSize = 20.sp)
        }
    }
}
