package com.example.ap2_mobile_gamedex.ui

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.unit.sp
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
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFF4F4F5)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onVoltar) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar",
                            tint = Color(0xFFF4F4F5)
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
            // Arthur: Botei a imagem em toda largura da tela
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(1.dp, Color(0xFF2E2E38)),
                shadowElevation = 12.dp
            ) {
                AsyncImage(
                    model = jogo.imagemUrl,
                    contentDescription = jogo.titulo,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp) // Altura de banner bem proporcional
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

            Spacer(Modifier.height(10.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(0xFF8B5CF6).copy(alpha = 0.25f)
                ) {
                    Text(
                        text = jogo.genero,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFFA78BFA),
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                    )
                }

                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(0xFF272730)
                ) {
                    Text(
                        text = "${jogo.ano}",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFFD4D4D8),
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                    )
                }

                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(0xFF18181B),
                    border = BorderStroke(1.dp, Color(0xFF2E2E38))
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = Color(0xFFA78BFA),
                            modifier = Modifier.size(13.dp)
                        )
                        Text(
                            text = "${jogo.nota}",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFA78BFA)
                        )
                    }
                }
            }

            Spacer(Modifier.height(24.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF272730)
                ),
                border = BorderStroke(1.dp, Color(0xFF3F3F46))
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(
                        text = "Descrição",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFA78BFA)
                    )

                    Spacer(Modifier.height(10.dp))

                    Text(
                        text = jogo.descricao,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color(0xFFFFFFFF),
                        lineHeight = 22.sp
                    )
                }
            }
        }
    }
}