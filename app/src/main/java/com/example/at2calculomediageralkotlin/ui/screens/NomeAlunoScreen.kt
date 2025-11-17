package com.example.at2calculomediageralkotlin.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.at2calculomediageralkotlin.ui.components.HeaderSection
import com.example.at2calculomediageralkotlin.ui.components.InputSection

@Composable
fun NomeAlunoScreen(navController: NavController) {
    var nome by remember { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }

    val primaryColor = Color(0xFF5B7FFF)
    val backgroundColor = Color(0xFFF8F9FE)
    val cardBackground = Color.White
    val textColor = Color(0xFF1A1A2E)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(horizontal = 20.dp, vertical = 40.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderSection(primaryColor, textColor)
        InputSection(
            nome = nome,
            isFocused = isFocused,
            onNomeChange = { nome = it },
            primaryColor = primaryColor,
            cardBackground = cardBackground,
            textColor = textColor,
            onNextClick = { if (nome.isNotBlank()) navController.navigate("notas/$nome") },
            isNextEnabled = nome.isNotBlank()
        )
    }
}
