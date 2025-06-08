package com.the43h1.jetpackcompose.C_Core_Components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AllButtons() {
    val context1 = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            // Simple Button
            Button(onClick = {
                Toast.makeText(
                    context1,
                    "Button Clicked",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Text("Simple Button")
            }

            // Filled Tonal Button
            FilledTonalButton(onClick = {
                Toast.makeText(
                    context1,
                    "Toast Button Clicked",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Text("Filled Tonal Button")
            }

            // Outlined Button
            OutlinedButton(onClick = {
                Toast.makeText(
                    context1,
                    "Outlined Button Clicked",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Text("Outlined Button")
            }

            // Elevated Button
            ElevatedButton(onClick = {
                Toast.makeText(
                    context1,
                    "Elevated Button Clicked",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Text("Elevated Button")
            }

            // Text Button
            TextButton(onClick = {
                Toast.makeText(
                    context1,
                    "Text Button Clicked",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Text("Text Button")
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewButtons() {
    AllButtons()
}