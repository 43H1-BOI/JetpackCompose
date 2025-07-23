package com.the43h1.jetpackcompose.A_Google.D_Affirmation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.the43h1.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                Affirmation_App()
            }
        }
    }
}

@Composable
fun Affirmation_App(modifier: Modifier = Modifier) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .background(Color(0xff213a71))
            .padding(8.dp)
    ) {
        items(DataClass.getList()) {
            Affirmation_Card(it)
        }
    }
}

@Composable
fun Affirmation_Card(affirmation: Affirmation, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(contentColor = MaterialTheme.colorScheme.onPrimary)
    ) {
        Column {
            Image(
                painter = painterResource(affirmation.imageRes),
                contentDescription = stringResource(affirmation.stringRes),
                contentScale = ContentScale.Crop,
                modifier = Modifier.aspectRatio(16f / 9f)
            )
            Text(
                text = stringResource(affirmation.stringRes),
                fontStyle = MaterialTheme.typography.bodyMedium.fontStyle,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                fontWeight = FontWeight.W500
            )
        }
    }
}

