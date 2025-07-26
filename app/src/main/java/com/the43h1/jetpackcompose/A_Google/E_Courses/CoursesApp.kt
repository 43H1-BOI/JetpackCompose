package com.the43h1.jetpackcompose.A_Google.E_Courses

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Grain
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true)
@Composable
fun Courses_App() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(Data.getData()) {
            Topic_Card(it)
        }
        items(Data.getData()) {
            Topic_Card(it)
        }
    }
}

@Composable
fun Topic_Card(topic: Topic, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxHeight()
            .padding(4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row {
            Image(
                painterResource(topic.image), stringResource(topic.text),
                modifier = Modifier
                    .weight(1.5f),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(4.dp)
                    .weight(3f)
            ) {
                Text(stringResource(topic.text), fontSize = 20.sp)
                Row(
                    horizontalArrangement = Arrangement.Absolute.Left,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(18.dp)
                        .fillMaxWidth()
                ) {
                    Icon(Icons.Default.Grain, null)
                    Text(topic.itemCount.toString(), fontSize = 16.sp)
                }
            }
        }
    }
}