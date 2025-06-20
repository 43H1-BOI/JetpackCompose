package com.the43h1.jetpackcompose.A_Practice_Apps.QuotesApp_6

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun InnerCard(
    imgId: Int,
    imgDesc: String? = null,
    quote: String,
    author: String,
    onClick: () -> Unit,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier.Companion
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.sweepGradient(
                    listOf(Color.Red, Color.Green, Color.Blue, Color.Red),
                )
            )
            .clickable {
                onClick()
            }
    ) {
        Card(
            modifier = Modifier.padding(25.dp),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Column(
                modifier = modifier
                    .padding(15.dp)
            ) {
                Image(
                    painter = painterResource(imgId),
                    contentDescription = imgDesc,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.Companion
                        .size(300.dp)
                        .align(Alignment.Companion.CenterHorizontally)
                )
                QuoteTexts(
                    quote = quote,
                    author = author
                )
            }
        }
    }
}