package com.the43h1.jetpackcompose.H_Chips

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.AssistChip
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AllChipsEx() {
    var enabled by remember {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AssistChip(
            onClick = {
                enabled = !enabled
            },
            label = {
                if (enabled)
                    Text("Enabled Assist Chip")
                else
                    Text("Disabled Assist Chip")
            },
            trailingIcon = {
                Icon(
                    Icons.Filled.Close,
                    null,
                    Modifier.size(InputChipDefaults.AvatarSize)
                )
            }
        )

        FilterChip(
            selected = enabled,
            onClick = {
                enabled = !enabled
            },
            label = {
                if (enabled)
                    Text("Enabled Filter Chip")
                else
                    Text("Disabled Filter Chip")
            },
            leadingIcon = {
                if (enabled) {
                    Icon(
                        Icons.Filled.Done,
                        null,
                        Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            }
        )

        InputChip(
            selected = enabled,
            onClick = {
                enabled = !enabled
            },
            label = {
                if (enabled)
                    Text("Enabled Input Chip")
                else
                    Text("Disabled Input Chip")
            },
            avatar = {
                Icon(
                    Icons.Filled.Close,
                    null,
                    Modifier.size(InputChipDefaults.AvatarSize)
                )
            }
        )
    }
}


// No Such Difference Just Different Implementations
@Preview(showSystemUi = true)
@Composable
fun AllChipsPreview() {
    AllChipsEx()
}