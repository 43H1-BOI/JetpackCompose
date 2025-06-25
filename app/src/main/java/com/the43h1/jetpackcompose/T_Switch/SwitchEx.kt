package com.the43h1.jetpackcompose.T_Switch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SwitchEx() {

    var switchState by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Switch(
            checked = switchState,
            onCheckedChange = { switchState = !switchState },
            modifier = Modifier,
            thumbContent = {
                Icon(
                    imageVector = if (switchState)
                        Icons.Default.Check
                    else
                        Icons.Default.Clear,
                    ""
                )
            },
            enabled = true,
            colors = SwitchDefaults.colors(
            )
        )
    }
}

@Preview
@Composable
private fun SwitchPreview() {
    Surface {
        SwitchEx()
    }
}

/** Add Switch by Using Switch() Composable Fun
 */