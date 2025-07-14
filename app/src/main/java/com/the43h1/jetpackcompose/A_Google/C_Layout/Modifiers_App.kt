package com.the43h1.jetpackcompose.A_Google.C_Layout

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showSystemUi = true)
@Composable
fun Modifiers_App(modifier: Modifier = Modifier) {
    var searchValue by remember { mutableStateOf("") }

    Column {
        OutlinedTextField(
            value = searchValue,
            onValueChange = { searchValue = it }
        )
    }
}