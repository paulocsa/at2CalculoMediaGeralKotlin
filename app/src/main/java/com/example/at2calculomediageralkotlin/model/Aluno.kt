package com.example.at2calculomediageralkotlin.model

data class Aluno(
    val nome: String,
    val notas: MutableList<Double>
) {
    fun calcularMedia(): Double {
        return if (notas.isNotEmpty()) notas.average() else 0.0
    }

    fun statusFinal(): String {
        val media = calcularMedia()
        return when {
            media > 9.0 -> "🌟 Ótimo Aproveitamento"
            media >= 6.0 -> "✅ Aprovado"
            else -> "❌ Reprovado"
        }
    }
}
