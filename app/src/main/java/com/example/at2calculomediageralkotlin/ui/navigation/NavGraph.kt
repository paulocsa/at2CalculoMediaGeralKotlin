package com.example.at2calculomediageralkotlin.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.at2calculomediageralkotlin.ui.screens.NomeAlunoScreen
import com.example.at2calculomediageralkotlin.ui.screens.NotasAlunoScreen
import com.example.at2calculomediageralkotlin.ui.screens.ResultadoScreen

object Routes {
    const val NOME = "nome"
    const val NOTAS = "notas/{nome}"
    const val RESULTADO = "resultado/{nome}/{tp1}/{tp2}/{tp3}"
}

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.NOME
    ) {
        composable(Routes.NOME) {
            NomeAlunoScreen(navController)
        }
        composable(
            route = Routes.NOTAS,
            arguments = listOf(navArgument("nome") { type = NavType.StringType })
        ) { backStackEntry ->
            val nome = backStackEntry.arguments?.getString("nome") ?: ""
            NotasAlunoScreen(navController, nome)
        }
        composable(
            route = Routes.RESULTADO,
            arguments = listOf(
                navArgument("nome") { type = NavType.StringType },
                navArgument("tp1") { type = NavType.FloatType },
                navArgument("tp2") { type = NavType.FloatType },
                navArgument("tp3") { type = NavType.FloatType }
            )
        ) { backStackEntry ->
            val nome = backStackEntry.arguments?.getString("nome") ?: ""
            val tp1 = backStackEntry.arguments?.getFloat("tp1")?.toDouble() ?: 0.0
            val tp2 = backStackEntry.arguments?.getFloat("tp2")?.toDouble() ?: 0.0
            val tp3 = backStackEntry.arguments?.getFloat("tp3")?.toDouble() ?: 0.0
            ResultadoScreen(navController, nome, tp1, tp2, tp3)
        }
    }
}
