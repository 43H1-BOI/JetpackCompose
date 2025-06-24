package com.the43h1.jetpackcompose.C_Core_Components

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                withStyle(
                    // Used to apply styling to paragraph
                    style = ParagraphStyle(
                        textAlign = TextAlign.Center
                    )
                ) {
                    append("I am not here to\n")
                    withStyle(
                        // Used to apply styling to text
                        style = SpanStyle(
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
            }
        )
    }
}

@Composable
fun MovingText() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
//        Text(text = "Breaking News : Pushpa Bhau ne di Sikhawat ko Dhamki")
        Text(
            text = "Jo Maal Aana Hoga Aaega , Jo Maal Jana Hoga Jaega ,Or Tujhe Ek Phooti Kodi bhi nhi milegi . Me Dekhta hu tu Kese Rokega Kutte !",
            modifier = Modifier
                .basicMarquee()
                .padding(2.dp)
        )
//        Text(text = "Me Dekhta hu tu Kese Rokega Kutte !")
//        Text(text = "Tujhe Ek Phooti Kodi bhi nhi milegi")
    }
}

@Composable
fun OverflowText() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Google has recently unveiled Material 3 Expressive, an evolution of its Material Design 3 system, focusing on enhanced expressiveness and customizability for Android and Wear OS devices. This design update aims to create a more personal and emotionally impactful user experience. It's not a new version of Material Design, but rather a refinement with new features and design tactics. \n".repeat(
                50
            ),
            maxLines = 4,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.width(350.dp)
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun TextPreview() {
//     Uncomment Below Lines to Check Their Previews
//    SimpleText()
    RainbowText()
//    MovingText()
//    OverflowText()
}