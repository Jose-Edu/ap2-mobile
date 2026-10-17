package com.example.ap2_mobile_gamedex.model

data class Jogo(
    val id: Int,
    val titulo: String,
    val genero: String,
    val ano: Int,
    val nota: Double,
    val imagemUrl: String,
    val descricao: String
)