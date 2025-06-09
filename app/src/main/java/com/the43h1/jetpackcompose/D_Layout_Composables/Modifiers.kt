package com.the43h1.jetpackcompose.D_Layout_Composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.the43h1.jetpackcompose.R

@Composable
fun ModifiersEx() {
    Box(
        modifier = Modifier
            .statusBarsPadding()
            .size(300.dp)
            .background(colorResource(R.color.purple_200)),
//        contentAlignment = Alignment.Center
    ) {
        Text(
            "This is My Text",
            modifier = Modifier
                .size(100.dp)
                .background(Color.Cyan)
                .align(Alignment.CenterStart)
                .border(2.dp, Color.Black)
                .padding(top = 30.dp),
            color = colorResource(R.color.blue),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center
        )

        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(100.dp)
                .background(Color.Red)
                .align(Alignment.BottomEnd)
                .border(10.dp, Color.Black, CircleShape)
        )
    }
}


// Modifiers are used to modify configurations of any Composable
// All Composable function has the parameter modifier in it
@Preview(showSystemUi = true)
@Composable
fun PreviewModifiers() {
    ModifiersEx()
}