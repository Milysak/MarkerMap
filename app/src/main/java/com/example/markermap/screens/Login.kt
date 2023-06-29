package com.example.markermap.screens

import android.content.Intent
import android.graphics.Color
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.markermap.AppActivity
import com.example.markermap.MainActivity
import com.example.markermap.app.Routes

@Composable
fun LoginPage(navController: NavController){
    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val username = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }

        Text(text = "Welcome Back!", fontSize = 35.sp)

        Spacer(modifier = Modifier.height(40.dp))

        OutlinedTextField(
            value = username.value,
            shape = RoundedCornerShape(15.dp),
            label = { Text(text = "Username") },
            onValueChange = {
                username.value = it
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = password.value,
            shape = RoundedCornerShape(15.dp),
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { password.value = it })

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
            onClick = { navController.navigate(Routes.SignUp.route) },
            modifier = Modifier
                .width(250.dp)
                .height(50.dp),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(text = "Register", fontSize = 20.sp)
        }
    }
}