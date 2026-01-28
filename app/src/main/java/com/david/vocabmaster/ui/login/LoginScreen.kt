package com.david.vocabmaster.ui.login

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.david.vocabmaster.model.LoginViewModel

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel = LoginViewModel()) {

    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    val error by viewModel.error.collectAsState()
}