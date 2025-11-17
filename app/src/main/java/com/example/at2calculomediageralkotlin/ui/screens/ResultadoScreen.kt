package com.example.at2calculomediageralkotlin.ui.screens

import com.example.at2calculomediageralkotlin.model.Aluno
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import androidx.navigation.NavController
import com.example.at2calculomediageralkotlin.ui.components.ResultadoHeader
import com.example.at2calculomediageralkotlin.ui.components.GradeDetailRow

@Composable
fun ResultadoScreen(navController: NavController, nome: String, tp1: Double, tp2: Double, tp3: Double) {
    val aluno = Aluno(nome, mutableListOf(tp1, tp2, tp3))
    val media = aluno.calcularMedia()

    val backgroundColor = Color(0xFFF8F9FE)
    val cardBackground = Color.White
    val textColor = Color(0xFF1A1A2E)

    val resultColor = when {
        media > 9.0 -> Color(0xFF4CAF50)
        media >= 6.0 -> Color(0xFFFF9500)
        else -> Color(0xFFE74C3C)
    }

    val resultEmoji = when {
        media > 9.0 -> "⭐"
        media >= 6.0 -> "✅"
        else -> "⚠️"
    }

    val resultText = when {
        media > 9.0 -> "Ótimo Aproveitamento"
        media >= 6.0 -> "Aprovado"
        else -> "Reprovado"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 40.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            ResultadoHeader(nome, textColor)

            Spacer(modifier = Modifier.height(32.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize()
                    .shadow(8.dp, RoundedCornerShape(20.dp)),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = cardBackground)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(50.dp))
                            .background(resultColor.copy(alpha = 0.1f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            resultEmoji,
                            fontSize = 48.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        "Sua Média Geral",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = Color(0xFF7A8A99),
                            fontSize = 13.sp
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        String.format("%.2f", media),
                        style = MaterialTheme.typography.displayMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = resultColor,
                            fontSize = 56.sp
                        )
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(resultColor.copy(alpha = 0.1f))
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            resultText,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = resultColor,
                                fontSize = 16.sp
                            )
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Grade Details
            Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                GradeDetailRow("TP1", tp1)
                GradeDetailRow("TP2", tp2)
                GradeDetailRow("TP3", tp3)
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { navController.navigate("nome") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(12.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = resultColor)
            ) {
                Text(
                    "Novo cálculo",
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}
