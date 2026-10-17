package com.example.ap2_mobile_gamedex.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.ap2_mobile_gamedex.data.JogoRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalheScreen(jogoId: Int, onVoltar: () -> Unit) {
    val jogo = JogoRepository.listar().first { it.id == jogoId }

    Scaffold(
        containerColor = Color(0xFF121214),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = jogo.titulo,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFFE1E1E6)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onVoltar) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color(0xFFE1E1E6)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF18181B)
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                shadowElevation = 8.dp
            ) {
                AsyncImage(
                    model = jogo.imagemUrl,
                    contentDescription = jogo.titulo,
                    modifier = Modifier
                        .size(width = 160.dp, height = 220.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(Modifier.height(20.dp))

            Text(
                text = jogo.titulo,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFFFFFFF)
            )

            Spacer(Modifier.height(6.dp))

            Text(
                text = "${jogo.ano} · ${jogo.genero}",
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFFA1A1AA)
            )

            Spacer(Modifier.height(12.dp))

            // Badge de Nota em Destaque Dark
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF8B5CF6).copy(alpha = 0.25f)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = Color(0xFFA78BFA),
                        modifier = Modifier.size(18.dp)
                    )
                    Text(
                        text = "${jogo.nota} / 10",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFA78BFA)
                    )
                }
            }

            Spacer(Modifier.height(24.dp))

            Text(
                text = "Descrição",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFE1E1E6),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = jogo.descricao,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFFA1A1AA),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}