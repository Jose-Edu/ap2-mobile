package com.example.ap2_mobile_gamedex.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.ap2_mobile_gamedex.data.JogoRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalheScreen(jogoId: Int, onVoltar: () -> Unit) {
    val jogo = JogoRepository.listar().first { it.id == jogoId }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(jogo.titulo) },
                navigationIcon = {
                    IconButton(onClick = onVoltar) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).padding(16.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = jogo.imagemUrl, contentDescription = jogo.titulo,
                modifier = Modifier.size(width = 120.dp, height = 170.dp).clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.height(16.dp))
            Text(jogo.titulo, style = MaterialTheme.typography.headlineSmall)
            Text("${jogo.ano} · ${jogo.genero}")
            Text("★ ${jogo.nota}", color = MaterialTheme.colorScheme.primary)
            Spacer(Modifier.height(16.dp))
            Text("Descrição", style = MaterialTheme.typography.titleMedium, modifier = Modifier.fillMaxWidth())
            Text(jogo.descricao)
        }
    }
}