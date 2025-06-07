package com.the43h1.jetpackcompose.C_Core_Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.R


@Composable
fun EverythingCombined() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.tv_mockup),
            contentDescription = null
        )
        Text(
            buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        fontWeight = FontWeight.Bold,
                        background = colorResource(R.color.red)
                    )
                ) {
                    append(" Breaking News ")
                }
                append(" Pushpa Bhau v/s Sikhawat")
            }, fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .absoluteOffset(x = 0.dp, y = (-73).dp)
                .padding(10.dp),
            fontSize = 15.6f.sp
        )
        Box(modifier = Modifier.width(303.dp)) {
            Text(
                text = "Jo Maal Aana Hoga Aaega , Jo Maal Jana Hoga Jaega ,Or Tujhe Ek Phooti Kodi bhi nhi milegi . Me Dekhta hu tu Kese Rokega Kutte !",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .absoluteOffset(x = 0.dp, y = 73.dp)
                    .background(colorResource(R.color.orange))
                    .basicMarquee(
                        repeatDelayMillis = 0
//                ,     animationMode = MarqueeAnimationMode.WhileFocused
                        )
                )
            }

            var review by rememberSaveable {
                mutableStateOf("")
            }

            TextField(
                value = review,
                onValueChange = {
                    review = it
                },
                label = {
                    Text("Enter Your Reviews on this Matter")
                },
                modifier = Modifier
                    .absoluteOffset(x = 0.dp, y = (0).dp)
                    .size(height = 125.dp, width = 300.dp)
            )
        } else if (password.equals("")) {

            Text(
                text, modifier = Modifier
                    .offset(
                        x = 0.dp, y = -(50).dp
                    ), fontWeight = FontWeight.SemiBold,
                textDecoration = TextDecoration.Underline,
                fontSize = 30.sp, color = colorResource(R.color.white)
            )

        } else {
            Text(
                "Entered Wrong Password ! Try Again...", modifier = Modifier
                    .offset(
                        x = 0.dp, y = -(50).dp
                    ), fontWeight = FontWeight.SemiBold,
                fontSize = 30.sp, color = colorResource(R.color.red),
            ).delay(1000)
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun ShowPreview() {
    EverythingCombined()
}