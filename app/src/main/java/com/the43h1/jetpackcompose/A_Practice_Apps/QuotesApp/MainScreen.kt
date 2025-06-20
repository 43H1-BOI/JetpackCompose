package com.the43h1.jetpackcompose.A_Practice_Apps.QuotesApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.R

@Composable
fun CardView(
    imgId: Int,
    imgDesc: String? = null,
    quote: String,
    author: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)

        ) {
            Image(
                painter = painterResource(imgId),
                contentDescription = imgDesc,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(5.dp)
                    .clip(CircleShape)
                    .weight(0.2f)
            )

            QuoteTexts(quote, author)
        }
    }
}

@Composable
private fun RowScope.QuoteTexts(
    quote: String,
    author: String
) {
    Column(
        modifier = Modifier
            .weight(0.8f)
    ) {
        Text(
            text = quote,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 3.dp,
                    bottom = 2.dp
                )
        )

        Text(
            text = "- $author",
            fontWeight = FontWeight.Light,
            fontSize = 20.sp,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 2.dp,
                    end = 5.dp,
                    bottom = 3.dp
                )
        )
    }
}

@Preview
@Composable
private fun PrevQuotes() {
    CardView(
        R.drawable.pfp_40_super,
        "SpiderMan with his GF",
        "With Great Powers , Comes Great Resposibilities",
        "Peter Parker"
    )
}