package com.david.vocabmaster.ui.stats

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.david.vocabmaster.AppScaffold

@Composable
fun StatsScreen(navController: NavController) {

    val viewModel: StatsViewModel = viewModel()

    val totalWords by viewModel.totalWords.collectAsState()
    val streak by viewModel.streak.collectAsState()
    val lastAccess by viewModel.lastAccess.collectAsState()



    AppScaffold(navController) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
        ) {
            Text("Estadísticas", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            StatCard("Palabras aprendidas", totalWords.toString())
            StatCard("Racha de días", streak.toString())
            StatCard("último acceso", formatDate(lastAccess))
        }
    }
}
    fun formatDate(ms: Long) : String {
        if (ms == 0L) return "Nunca"
        val date = java.text.SimpleDateFormat("dd/MM/yyyy").format(ms)
        return date
    }
@Composable
fun StatCard(title: String, value: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(Modifier.padding(16.dp)){
            Text(title, style = MaterialTheme.typography.titleMedium)
            Text(value, style = MaterialTheme.typography.headlineMedium)
        }
    }
}