package com.the43h1.jetpackcompose.H_Input_Chip

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
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
fun MineInputChip() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var enabled by remember {
            mutableStateOf(true)
        }

        InputChip(
            selected = enabled,
            onClick = {
                enabled =
                    if (enabled) false
                    else true
            },
            label = {
                if (enabled) Text("Enabled")
                else Text("Disabled")
            },

            leadingIcon = {
                AnimatedVisibility(
                    enabled,
                    enter = expandHorizontally(expandFrom = Alignment.Start),
                    exit = ExitTransition.None
                ) {
                    Icon(
                        Icons.Filled.Done,
                        null,
                        Modifier
                            .size(InputChipDefaults.AvatarSize)
                    )
                }
            },

            trailingIcon = {
                AnimatedVisibility(
                    !enabled,
                    enter = expandHorizontally(),
                    exit = ExitTransition.None
                ) {
                    Icon(
                        Icons.Filled.Clear,
                        null,
                        Modifier
                            .size(InputChipDefaults.AvatarSize)
                    )
                }
            }

        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun MineInputChipPreview() {
    MineInputChip()
}
