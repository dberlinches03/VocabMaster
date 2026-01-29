package com.david.vocabmaster.ui.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.david.vocabmaster.AppScaffold
import com.david.vocabmaster.model.SettingsViewModel

@Composable
fun SettingsScreen(navController: NavController) {

    val viewModel: SettingsViewModel = viewModel()
    val darkMode by viewModel.darkMode.collectAsState()
    val language by viewModel.language.collectAsState()


    AppScaffold(navController) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ){
            Text("Ajustes", style = MaterialTheme.typography.headlineMedium)

            Spacer(Modifier.height(24.dp))

            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text("Modo oscuro")
                Switch(
                    checked = darkMode,
                    onCheckedChange = { viewModel.setDarkMode(it) }
                )
            }

            Spacer(Modifier.height(12.dp))

            Text("Idioma", style = MaterialTheme.typography.titleMedium)

            Spacer(Modifier.height(12.dp))

            DropdownMenuLanguage( selected = language,
                onSelect = { viewModel.setLanguage(it) }
            )
        }
    }
}

@Composable
fun DropdownMenuLanguage(selected: String, onSelect: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val languages = listOf("es", "en", "fr")

    Box {
        Button(onClick = { expanded = true }) {
            Text("Idioma: $selected")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {expanded = false}
        ) {
            languages.forEach { lang ->
                DropdownMenuItem(
                    text = {Text(lang.uppercase()) },
                    onClick = {
                        onSelect(lang)
                        expanded = false
                    }
                )
            }
        }

    }
}