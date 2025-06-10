package com.the43h1.jetpackcompose.H_Chips

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
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
fun InputChipCode() {
    var enabled by remember {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .statusBarsPadding(),
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = {
            enabled = !enabled
        }) { Text("Toggle Button") }

        if (enabled) {
            InputChip(
                selected = enabled,
                onClick = {
                    enabled = false
                },
                label = {
                    Text("Input Chip")
                },
                leadingIcon = {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = null,
                        Modifier.size(InputChipDefaults.AvatarSize)
                    )
                },
//                avatar = {
//                    Icon(
//                        Icons.Filled.Build,
//                        null,
//                        Modifier.size(InputChipDefaults.AvatarSize)
//                    )
//                },
                // Both are Same but avatar got some priorities
                trailingIcon = {
                    Icon(
                        Icons.Filled.Close,
                        null,
                        Modifier.size(InputChipDefaults.AvatarSize)
                    )
                },
//                shape = TODO(),
//                colors = TODO(),
//                elevation = TODO(),
//                border = TODO(),
//                interactionSource = TODO()
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun InputChipPreview() {
    InputChipCode()
}
