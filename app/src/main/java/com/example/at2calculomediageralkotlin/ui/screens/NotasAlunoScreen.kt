package com.example.at2calculomediageralkotlin.ui.screens

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.at2calculomediageralkotlin.ui.components.GradeInputCard
import com.example.at2calculomediageralkotlin.ui.components.NotasHeader

@Composable
fun NotasAlunoScreen(navController: NavController, nome: String) {
    var tp1 by remember { mutableStateOf(0.0) }
    var tp2 by remember { mutableStateOf(0.0) }
    var tp3 by remember { mutableStateOf(0.0) }

    val primaryColor = Color(0xFF5B7FFF)
    val tp1Color = Color(0xFF5B7FFF)
    val tp2Color = Color(0xFFFF9500)
    val tp3Color = Color(0xFF4CAF50)
    val backgroundColor = Color(0xFFF8F9FE)
    val cardBackground = Color.White
    val textColor = Color(0xFF1A1A2E)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NotasHeader(nome, textColor)

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(4.dp, RoundedCornerShape(16.dp)),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = cardBackground)
        ) {
            Column(modifier = Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(20.dp)) {
                GradeInputCard("TP1", tp1, { tp1 = it }, tp1Color)
                GradeInputCard("TP2", tp2, { tp2 = it }, tp2Color)
                GradeInputCard("TP3", tp3, { tp3 = it }, tp3Color)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                navController.navigate("resultado/$nome/$tp1/$tp2/$tp3")
            },
            enabled = tp1 in 0.0..10.0 && tp2 in 0.0..10.0 && tp3 in 0.0..10.0,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(14.dp)),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4CAF50),
                disabledContainerColor = Color(0xFFE0E0E0)
            )
        ) {
            Text(
                "Ver Resultado",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}
