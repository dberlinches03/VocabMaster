package com.david.vocabmaster.ui.stats

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.david.vocabmaster.AppScaffold

@Composable
fun StatsScreen(navController: NavController) {
    AppScaffold(navController) {
        Text("Pantalla de estadisticas")
    }
}