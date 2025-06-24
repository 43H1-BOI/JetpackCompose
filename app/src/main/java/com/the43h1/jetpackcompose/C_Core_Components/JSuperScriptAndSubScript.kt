package com.the43h1.jetpackcompose.C_Core_Components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit

@Preview
@Composable
fun SubScript(
    mainText: String = "A",
    mainTextSize: TextUnit = MaterialTheme.typography.displayLarge.fontSize,
    subScript: String = "X",
    subScriptSize: TextUnit = mainTextSize / 2
) {
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = mainTextSize
                )
            ) {
                append(mainText)
            }
            withStyle(
                style = SpanStyle(
                    fontSize = subScriptSize,
                    baselineShift = BaselineShift.Subscript,
                    fontWeight = FontWeight.Normal
                )
            )
            {append(subScript) }
        }
    )
}