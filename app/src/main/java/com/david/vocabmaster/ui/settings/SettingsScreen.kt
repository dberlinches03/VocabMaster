package com.david.vocabmaster.ui.settings

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.david.vocabmaster.AppScaffold

@Composable
fun SettingsScreen(navController: NavController) {
    AppScaffold(navController) {
        Text("Pantalla de ajustes")
    }
}