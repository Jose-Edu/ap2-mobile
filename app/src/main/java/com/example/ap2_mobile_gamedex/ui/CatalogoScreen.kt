package com.example.ap2_mobile_gamedex.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ap2_mobile_gamedex.data.JogoRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogoScreen(onJogoClick: (Int) -> Unit) {
    Scaffold(topBar = { TopAppBar(title = { Text("Catálogo de Jogos") }) }) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(JogoRepository.listar(), key = { it.id }) {
                JogoCard(it) { onJogoClick(it.id) }
            }
        }
    }
}