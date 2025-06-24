package com.the43h1.jetpackcompose.C_Core_Components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun SubScript(
    mainText: String = "A",
    mainTextSize: TextUnit = 20.sp,
    subScript: String = "x",
    subScriptSize: TextUnit = mainTextSize / 2
) {

    Text(
        mainText,
        fontSize = mainTextSize
    )
    Text(
        subScript,
        fontSize = subScriptSize,
        textAlign = TextAlign.End, modifier = Modifier.padding(start = 10.dp)
    )
}