package com.the43h1.jetpackcompose.FCards

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.R


@Composable
fun ShoppingCards() {
var context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .size(350.dp, 200.dp)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item(20) {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(5.dp),
                modifier = Modifier.size(300.dp, 150.dp), onClick ={
                    Toast.makeText(context,"Toast is Here",Toast.LENGTH_SHORT).show()
                }
            ) {
                Image(
                    painter = painterResource(R.drawable.fruits),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RectangleShape)
                        .size(290.dp)
                )
            }

            ElevatedCard(
                elevation = CardDefaults.cardElevation(5.dp),
                modifier = Modifier.size(300.dp, 150.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.baatman),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RectangleShape)
                        .size(290.dp)
                )
            }

            ElevatedCard(
                elevation = CardDefaults.cardElevation(5.dp),
                modifier = Modifier.size(300.dp, 150.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.lotus),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RectangleShape)
                        .size(290.dp)
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