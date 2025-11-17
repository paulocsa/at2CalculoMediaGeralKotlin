package com.example.at2calculomediageralkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import com.example.at2calculomediageralkotlin.ui.theme.At2CalculoMediaGeralKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            At2CalculoMediaGeralKotlinTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    com.example.at2calculomediageralkotlin.ui.navigation.AppNavGraph()
                }
            }
        }
    }
}
