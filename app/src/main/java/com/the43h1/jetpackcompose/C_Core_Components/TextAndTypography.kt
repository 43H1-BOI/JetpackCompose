package com.the43h1.jetpackcompose.C_Core_Components

import android.graphics.BlurMaskFilter.Blur
import android.util.Size
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY
import com.the43h1.jetpackcompose.R

@Composable
fun SimpleText() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Text(
            text = "Hello Jetpack Compose",
            textAlign = TextAlign.Center,
            color = colorResource(R.color.black),
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            style = TextStyle(
                shadow = Shadow(
                    color = colorResource(R.color.mera_color),
                    blurRadius = 6f
                )
            )
        )
    }
}

@Composable
fun RainbowText() {
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
                            colors = rainbow,
                            endY = 135f
                        )
                    )
                ) {
                    append("Interfere in Anyone's Matter\n")
                    append("I am here to build my own Empire\n")
                }
                append("Samjhe ?!")
            }
        )
    }
}

@Composable
fun ScrollableText() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
//        Text(text = "Breaking News : Pushpa Bhau ne di Sikhawat ko Dhamki")
        Text(
            text = "Jo Maal Aana Hoga Aaega , Jo Maal Jana Hoga Jaega ,Or Tujhe Ek Phooti Kodi bhi nhi milegi . Me Dekhta hu tu Kese Rokega Kutte !",
            modifier = Modifier.basicMarquee().padding(2.dp)
        )
//        Text(text = "Me Dekhta hu tu Kese Rokega Kutte !")
//        Text(text = "Tujhe Ek Phooti Kodi bhi nhi milegi")
    }
}

@Preview(showSystemUi = true)
@Composable
fun TextPreview() {
    // Uncomment Below Lines to Check Their Previews
//    SimpleText()
//    RainbowText()
//    ScrollableText()
}