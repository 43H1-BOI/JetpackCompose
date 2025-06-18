package com.the43h1.jetpackcompose.A_CheezyCode

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.R

@Composable
fun ModifierEx() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.palm), null,
            modifier = Modifier
                .size(350.dp)
                .clip(CircleShape)
                .padding(10.dp)
                .border(
                    width = 5.dp,
                    brush = Brush.linearGradient(listOf(Color.Red, Color.Green, Color.Blue)),
                    shape = CircleShape
                ),
            contentScale = ContentScale.Crop
        )

        Text(
            "Change In Order Can Lead To This Type of Problem",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            textAlign = TextAlign.Center
        )

        Image(
            painter = painterResource(R.drawable.lotus), null,
            modifier = Modifier
                .size(350.dp)
                .padding(10.dp)
                .border(
                    width = 5.dp,
                    brush = Brush.linearGradient(listOf(Color.Red, Color.Green, Color.Blue)),
                    shape = CircleShape
                )
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun ModifierPreview() {
    ModifierEx()
}