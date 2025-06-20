package com.the43h1.jetpackcompose.A_Practice_Apps.QuotesApp_6

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun InnerCard(
    imgId: Int,
    imgDesc: String? = null,
    quote: String,
    author: String,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier.Companion
) {
    Card {
        Column(
            modifier = modifier
                .padding(15.dp)
        ) {
            Image(
                painter = painterResource(imgId),
                contentDescription = imgDesc,
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