package com.the43h1.jetpackcompose.P_Segmented_Button

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsRun
import androidx.compose.material.icons.automirrored.filled.DirectionsWalk
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material3.Icon
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SegmentedButtonEx() {

    var buttonState = remember {
        mutableStateListOf(false, false, false)
    }

    var buttons = listOf("Walk", "Run", "Drive")

    MultiChoiceSegmentedButtonRow(modifier = Modifier) {
        buttons.forEachIndexed { index, label ->
            SegmentedButton(
                checked = buttonState[index],
                onCheckedChange = {
                    buttonState[index] = !buttonState[index]
                },
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = buttons.size
                ),
                icon = {
                    SegmentedButtonDefaults.Icon(active = buttonState[index])
                },
                label = {
                    when (label) {
                        "Walk" -> Icon(Icons.AutoMirrored.Filled.DirectionsWalk, "Walk")
                        "Run" -> Icon(Icons.AutoMirrored.Filled.DirectionsRun, "Run")
                        "Drive" -> Icon(Icons.Default.DirectionsCar, "Drive")
                    }
                }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun SegmentedButtonPreview() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        SegmentedButtonEx()
    }
}