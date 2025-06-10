package com.the43h1.jetpackcompose.F_Cards

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ElevatedCardsEx() {
    Box(
        modifier = Modifier
            .fillMaxSize()
//            .background(Color.Magenta)
        , contentAlignment = Alignment.Center
    ) {
        ElevatedCard(
            modifier = Modifier
                .size(200.dp, 100.dp),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Text(
                "This is Elevated Card",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CardsPreview() {
    ElevatedCardsEx()
}