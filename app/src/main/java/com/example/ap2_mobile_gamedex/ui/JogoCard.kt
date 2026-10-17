package com.example.ap2_mobile_gamedex.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.ap2_mobile_gamedex.model.Jogo

@Composable
fun JogoCard(jogo: Jogo, onClick: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp)) {
        Row(modifier = Modifier.padding(12.dp).clickable(onClick = onClick)) {
            AsyncImage(
                model = jogo.imagemUrl,
                contentDescription = jogo.titulo,
                modifier = Modifier.size(width = 48.dp, height = 64.dp).clip(RoundedCornerShape(6.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(jogo.titulo, style = MaterialTheme.typography.titleMedium)
                Text("${jogo.ano} · ${jogo.genero}", style = MaterialTheme.typography.bodySmall)
                Text("★ ${jogo.nota}", color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}
