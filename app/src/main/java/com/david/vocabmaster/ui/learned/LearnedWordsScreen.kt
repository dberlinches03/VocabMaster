package com.david.vocabmaster.ui.learned

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.david.vocabmaster.AppScaffold

@Composable
fun LearnedWordsScreen(navController: NavController) {
    AppScaffold(navController) {
        Text("Palabras aprendidas")
    }
}