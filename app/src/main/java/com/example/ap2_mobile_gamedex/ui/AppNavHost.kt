package com.example.ap2_mobile_gamedex.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Lista
    ) {

        composable<Lista> {
            CatalogoScreen(
                onJogoClick = { id ->
                    navController.navigate(Detalhe(id))
                }
            )
        }

        composable<Detalhe> { backStackEntry ->
            val rota = backStackEntry.toRoute<Detalhe>()

            DetalheScreen(
                jogoId = rota.jogoId,
                onVoltar = { navController.popBackStack() }
            )
        }
    }
}