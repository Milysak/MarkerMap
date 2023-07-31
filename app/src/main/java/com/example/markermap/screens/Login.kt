package com.example.markermap.screens

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.markermap.AppActivity
import com.example.markermap.R
import com.example.markermap.app.Routes
import com.example.markermap.viewmodels.LoginViewModel
import com.example.markermap.viewmodels.MainActivityViewModel
import kotlinx.coroutines.*

@Composable
fun scaledSp(value: Int): TextUnit {
    return with(LocalDensity.current) {
        val fontScale = this.fontScale
        val textSize = value / fontScale
        textSize.sp
    }
}

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun LoginPage(navController: NavController, vm: MainActivityViewModel = viewModel()) {
    val viewModel = vm.loginViewModel

    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(0.dp, 0.dp, 0.dp, 50.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth(viewModel.componentsWidth)
                .height(55.dp)) {
            Text(
                text = "FIND",
                color = MaterialTheme.colorScheme.primary,
                fontSize = scaledSp(value = 50),
            )
            Text(
                text = "it",
                fontSize = scaledSp(value = 50),
                fontFamily = FontFamily.Serif
            )
            Icon(modifier = Modifier.size(50.dp),
                painter = painterResource(id = R.drawable.search_outlined),
                contentDescription = "AccountBox Icon")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(modifier = Modifier.fillMaxWidth(viewModel.componentsWidth),
            text = "WELCOME BACK!",
            fontSize = 30.sp,
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(viewModel.componentsWidth),
            value = viewModel.currentUsername,
            shape = RoundedCornerShape(15.dp),
            label = { Text(text = "Email") },
            onValueChange = {
                viewModel.currentUsername = it.trim()
            },
            leadingIcon = {
                Icon(modifier = Modifier.height(22.5.dp),
                    painter = painterResource(id = R.drawable.mail_filled_2),
                    contentDescription = "AccountBox Icon")
            },
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(20.dp))

        var passwordVisibility by remember { mutableStateOf(false) }

        val changeVisibilityIcon = if (passwordVisibility) painterResource(id = R.drawable.eye_filled) else painterResource(id = R.drawable.eye_crossed_filled)

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(viewModel.componentsWidth),
            value = viewModel.currentPassword,
            shape = RoundedCornerShape(15.dp),
            label = { Text(text = "Password") },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = {
                viewModel.currentPassword = it.trim()
            },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(modifier = Modifier.height(22.5.dp), painter = changeVisibilityIcon, contentDescription = "Show/Hide")
                }
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "Lock Icon")
            },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(50.dp))

        val mContext = LocalContext.current

        ExtendedFloatingActionButton(
            onClick = {
                CoroutineScope(Dispatchers.Main).launch {
                    viewModel.isLoading = true
                    delay(750)
                    if (vm.login(viewModel.currentUsername, viewModel.currentPassword)) {
                        Toast.makeText(mContext, "Log In Complete!", Toast.LENGTH_SHORT).show()
                        mContext.startActivity(Intent(mContext, AppActivity::class.java))
                    } else {
                        Toast.makeText(mContext, "Log In Failure!", Toast.LENGTH_SHORT).show()
                    }
                    viewModel.isLoading = false
                }
                      },
            modifier = Modifier
                .fillMaxWidth(viewModel.componentsWidth)
                .height(50.dp),
            icon = {
                if (viewModel.isLoading) {
                    CircularProgressIndicator(
                        Modifier.then(Modifier.size(22.5.dp)),
                        strokeWidth = 2.5.dp,
                        trackColor = MaterialTheme.colorScheme.onPrimary,
                    )
                } else {
                    Icon(modifier = Modifier.height(20.dp),
                        painter = painterResource(id = R.drawable.login_outlined),
                        contentDescription = "Favorite"
                    )
                }
            },
            text = { Text(if (!viewModel.isLoading) "Login" else "Processing...", fontSize = 20.sp) },
            containerColor = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(15.dp))
        Divider(modifier = Modifier.fillMaxWidth(viewModel.componentsWidth - 0.05f))
        Spacer(modifier = Modifier.height(15.dp))

        OutlinedButton(
            onClick = {
                if (!navController.navigateUp()) {
                    navController.navigate(Routes.SignUp.route)
                }
                      },
            modifier = Modifier
                .fillMaxWidth(viewModel.componentsWidth)
                .height(50.dp),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(text = "Register", fontSize = 20.sp)
        }
    }
}