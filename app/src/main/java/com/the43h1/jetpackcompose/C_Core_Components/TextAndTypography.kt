package com.the43h1.jetpackcompose.C_Core_Components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY

@Composable
fun SimpleText() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Text(
            text = "Hello Jetpack Compose",
            textAlign = TextAlign.Center ,
            color = colorResource(R.color.mera_color)
        )
    }
}

@Composable
fun RainbowText(){
    val rainbow = listOf(
        colorResource(R.color.violet),
        colorResource(R.color.indigo),
        colorResource(R.color.blue),
        colorResource(R.color.green),
        colorResource(R.color.yellow),
        colorResource(R.color.orange),
//      colorResource(R.color.red),
//              OR
        Color.Red
    )
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            // buildAnnotatedString for functions like append()
            text = buildAnnotatedString {
                append("I am not here to\n")
                // Used to apply styling to text
                withStyle(
                    SpanStyle(
                        brush = Brush.verticalGradient(
                            colors = rainbow ,
                            endY = 135f
                        )
                    )
                ) {
                    append("Interfere in Anyone's Matter\n")
                }
                append("I am here to build my own Empire")
            }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun TextPreview() {
    SimpleText()
}