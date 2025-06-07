package com.the43h1.jetpackcompose.B_Fundamentals

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Composable Function
@Composable
fun Greet(message: String) {
    Text(
        "Greeting Message : $message",
        modifier = Modifier.padding(horizontal = 100.dp, vertical = 100.dp)
    )
}

// If want to Preview
/*
@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
Greet("Hello JI !")
}
*/