package com.david.vocabmaster.ui.game

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.david.vocabmaster.AppScaffold
@Composable
fun GameScreen(navController: NavController) {

    val viewModel: GameViewModel = viewModel()

    val word by viewModel.currentWord.collectAsState()
    val options by viewModel.options.collectAsState()
    val selected by viewModel.selected.collectAsState()
    val isCorrect by viewModel.isCorrect.collectAsState()

    AppScaffold(navController) {

        if (word == null) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
            return@AppScaffold
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text("Asocia la definición", style = MaterialTheme.typography.headlineMedium)

            Spacer(Modifier.height(24.dp))

            Text(
                text = word!!.word,
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(Modifier.height(32.dp))

            options.forEach { def ->
                val bg = when {
                    selected == null -> MaterialTheme.colorScheme.surfaceVariant
                    def == selected && isCorrect == true -> Color(0xFFB2FF59) // verde
                    def == selected && isCorrect == false -> Color(0xFFFF8A80) // rojo
                    else -> MaterialTheme.colorScheme.surfaceVariant
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                        .clickable(enabled = selected == null) {
                            viewModel.selectOption(def)
                        }
                        .background(bg)
                ) {
                    Text(
                        text = def,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }

            Spacer(Modifier.height(32.dp))

            if (selected != null) {
                Button(onClick = { viewModel.newRound() }) {
                    Text("Siguiente")
                }
            }
        }
    }
}
