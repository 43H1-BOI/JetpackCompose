package com.the43h1.jetpackcompose.A_Practice_Apps.QuotesApp_6

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardView(
    imgId: Int,
    imgDesc: String? = null,
    quote: String,
    author: String,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier.Companion
) {
    Card(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.Companion.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)

        ) {
            Image(
                imageVector = Icons.Filled.Person,
                contentDescription = imgDesc,
                contentScale = ContentScale.Companion.Fit,
                modifier = Modifier.Companion
                    .padding(5.dp)
                    .clip(CircleShape)
                    .size(70.dp)
            )

            QuoteTexts(quote, author)
        }
    }
}

@Composable
internal fun QuoteTexts(
    quote: String,
    author: String,
    modifier: Modifier = Modifier.Companion
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = quote,
            fontWeight = FontWeight.Companion.SemiBold,
            fontSize = 20.sp,
            textAlign = TextAlign.Companion.Left,
            modifier = Modifier.Companion
                .fillMaxWidth()
                .padding(
                    5.dp
                )
        )

        Text(
            text = "- $author",
            fontWeight = FontWeight.Companion.Light,
            fontSize = 20.sp,
            textAlign = TextAlign.Companion.End,
            modifier = Modifier.Companion
                .fillMaxWidth()
                .padding(
                    5.dp
                )
        )
    }
}