package com.the43h1.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.the43h1.jetpackcompose.FCards.ShoppingCards
import com.the43h1.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTheme {
//                AccessResources()
//                ScrollableText()
//                EverythingCombined()
//                SimpleOne()
//                SelectableText()
//                AuthScreen()
//                AllButtons()
                ShoppingCards()
            }
        }
    }
}