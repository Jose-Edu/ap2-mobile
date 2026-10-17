package com.example.ap2_mobile_gamedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ap2_mobile_gamedex.ui.AppNavHost
import com.example.ap2_mobile_gamedex.ui.CatalogoScreen
import com.example.ap2_mobile_gamedex.ui.theme.Ap2mobilegamedexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ap2mobilegamedexTheme {
                AppNavHost()
            }
        }
    }
}