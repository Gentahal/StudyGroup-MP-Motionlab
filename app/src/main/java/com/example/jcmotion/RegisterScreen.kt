package com.example.jcmotion

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun RegisterScreen(navController: NavController) {
    var context = LocalContext.current
    var username by remember { mutableStateOf("") } // Menampung data username
    var email by remember { mutableStateOf("") } // Menampung data email
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    Scaffold(modifier = Modifier.fillMaxSize(), content = {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            Image(
                modifier = Modifier.size(120.dp),
                painter = painterResource(id = R.drawable.motion_logo),
                contentDescription = "Motion Logo",
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                colors = TextFieldDefaults.colors(
                    focusedLabelColor = Color.Red,
                    focusedIndicatorColor = Color.Red,
                    unfocusedIndicatorColor = Color.Red
                ),
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                colors = TextFieldDefaults.colors(
                    focusedLabelColor = Color.Red,
                    focusedIndicatorColor = Color.Red,
                    unfocusedIndicatorColor = Color.Red
                ),
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                colors = TextFieldDefaults.colors(
                    focusedLabelColor = Color.Red,
                    focusedIndicatorColor = Color.Red,
                    unfocusedIndicatorColor = Color.Red
                ),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon = if (passwordVisible) R.drawable.visible_off else R.drawable.visible
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(id = icon),
                            contentDescription = "Toggle Password Visibility"
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = {
                    Text("Confirm Password")
                },
                colors = TextFieldDefaults.colors(
                    focusedLabelColor = Color.Red,
                    focusedIndicatorColor = Color.Red,
                    unfocusedIndicatorColor = Color.Red
                ),
                visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon = if (confirmPasswordVisible) R.drawable.visible_off else R.drawable.visible
                    IconButton(onClick = {confirmPasswordVisible = !confirmPasswordVisible}) {
                        Icon(
                            painter = painterResource(id = icon),
                            contentDescription = "Toggle confirm password disible"
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    if (password != confirmPassword) {
                        Toast.makeText(context, "Pasword tidak sesuai", Toast.LENGTH_SHORT).show()
                        return@Button
                    }
                    val sharedPreferences =
                        context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
                    sharedPreferences.edit().putString("username", username)
                        .putString("email", email).apply()
                    Toast.makeText(
                        context, "Registrasi berhasil", Toast.LENGTH_SHORT
                    ).show()

                    navController.navigate(LoginScreen)
                },
                enabled = username.isNotBlank() && email.isNotBlank() && password.isNotBlank() && confirmPassword.isNotBlank(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red, contentColor = Color.White
                ),
            ) {
                Text(
                    text = "Register",
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Sudah punya akun? Login di sini",
                color = Color.Blue,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    })
}