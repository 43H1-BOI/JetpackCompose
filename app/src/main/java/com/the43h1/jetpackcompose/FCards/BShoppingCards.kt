package com.the43h1.jetpackcompose.FCards

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.the43h1.jetpackcompose.R


@Composable
fun ShoppingCards() {
    var context = LocalContext.current

    val uriHandler = LocalUriHandler.current

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(16f / 9f)
            .statusBarsPadding()
            .padding(20.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        item(10) {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(5.dp),
                modifier = Modifier
                    .aspectRatio(16f / 9f)
                    .fillMaxSize(),
                onClick = {
                    Toast.makeText(context, "Toast is Here", Toast.LENGTH_SHORT).show()
                    uriHandler.openUri(uri = "https://apple.com")
                }
            ) {
                Image(
                    painter = painterResource(R.drawable.fruits),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(5.dp)
                        .aspectRatio(16f / 9f)
                        .fillMaxSize()
                )
                Text("Fruits")
            }

            ElevatedCard(
                elevation = CardDefaults.cardElevation(5.dp),
                modifier = Modifier
                    .aspectRatio(16f / 9f)
                    .fillMaxSize(),
                onClick = {
                    Toast.makeText(context, "Toast is Here", Toast.LENGTH_SHORT).show()
                    uriHandler.openUri(uri = "https://marvel.com")
                }
            ) {
                Image(
                    painter = painterResource(R.drawable.baatman),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(5.dp)
                        .aspectRatio(16f / 9f)
                        .fillMaxSize()
                )
                Text("Batman")
            }

            ElevatedCard(
                elevation = CardDefaults.cardElevation(5.dp),
                modifier = Modifier
                    .aspectRatio(16f / 9f)
                    .fillMaxSize(),
                onClick = {
                    Toast.makeText(context, "Toast is Here", Toast.LENGTH_SHORT).show()
                    uriHandler.openUri(uri = "https://lotus.com")
                }
            ) {
                Image(
                    painter = painterResource(R.drawable.lotus),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(5.dp)
                        .aspectRatio(16f / 9f)
                        .fillMaxSize()
                )
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun ShoppingPreview() {
    ShoppingCards()
}