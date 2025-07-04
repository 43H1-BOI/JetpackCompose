package com.the43h1.jetpackcompose.H_Chips

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun AssistChipCode() {

    var enabled by remember {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier
            .padding(all = 20.dp)
            .fillMaxSize()
            .statusBarsPadding(),
        verticalArrangement = Arrangement.Center
    ) {

        Button(
            onClick = {
                enabled = !enabled
            }
        ) { Text("Toggle Button") }

        if (enabled) {
            AssistChip(
                onClick = {
                    enabled = false
                },
                label = {
                    Text("Input Chip")
                },
                trailingIcon = {
                    Icon(
                        Icons.Filled.Close,
                        null,
                        Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AssistChipPreview() {
    AssistChipCode()
}