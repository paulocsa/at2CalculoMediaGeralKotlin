package com.example.at2calculomediageralkotlin.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NotasHeader(nome: String, textColor: Color) {
    Text(
        "Notas de $nome",
        style = MaterialTheme.typography.headlineSmall.copy(
            fontWeight = FontWeight.Bold,
            color = textColor,
            fontSize = 24.sp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    )

    Text(
        "Digite as 3 notas de avaliação",
        style = MaterialTheme.typography.bodySmall.copy(
            color = Color(0xFF7A8A99),
            fontSize = 13.sp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp)
    )
}
