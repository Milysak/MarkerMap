package com.example.markermap.screens

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
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
import com.example.markermap.viewmodels.SignUpViewModel
import java.time.format.TextStyle

@Composable
fun scaledSp(value: Int): TextUnit {
    return with(LocalDensity.current) {
        val fontScale = this.fontScale
        val textSize = value / fontScale
        textSize.sp
    }
}

@Composable
fun LoginPage(navController: NavController, viewModel: LoginViewModel = viewModel()){
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
                viewModel.currentUsername = it
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
                viewModel.currentPassword = it
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
            onClick = { mContext.startActivity(Intent(mContext, AppActivity::class.java)) },
            modifier = Modifier
                .fillMaxWidth(viewModel.componentsWidth)
                .height(50.dp),
            icon = {
                Icon(modifier = Modifier.height(20.dp),
                    painter = painterResource(id = R.drawable.login_outlined),
                    contentDescription = "Favorite"
                )
            },
            text = { Text("Login", fontSize = 20.sp) },
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