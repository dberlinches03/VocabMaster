package com.david.vocabmaster.ui.learned

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
fun LearnedWordsScreen(navController: NavController) {

    val viewModel: LearnedWordsViewModel = viewModel()
    val words by viewModel.words.collectAsState()

    AppScaffold(navController) {

        Column (modifier = Modifier.padding(16.dp)){

            Text("Palabras aprendidas")
            Spacer(Modifier.height(16.dp))

            LazyColumn {
                items(words) { item ->
                    Card (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                    ){
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(item.word, style = MaterialTheme.typography.titleLarge)
                            Text(item.definition)
                        }
                    }
                }
            }
        }
    }
}