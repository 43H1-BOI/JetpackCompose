package com.the43h1.jetpackcompose.A_Practice_Apps

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.R

@Composable
fun PhotoAppLayout() {
    var imageDesc = mapOf<Painter, String>(
        painterResource(R.drawable.fruits) to "4 Fruits |Abhishek Yadav(2025)",
//        painterResource(R.drawable.pinkflower) to "These are Pink Flowers",
//        painterResource(R.drawable.palm) to "This is Palm Tree",
//        painterResource(R.drawable.monkey) to "This is Hanumanth"
    )

    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
            .padding(20.dp)
            .statusBarsPadding()
    ) {

        for ((image, desc) in imageDesc) {
            Image(
                painter = image,
                contentDescription = null,

                modifier = Modifier
                    .size(600.dp, 400.dp)
            )

            // Index of | character which separates Image Description and Owner of Image
            var indexSp = desc.indexOf('|')

            Column() {
                Text(
                    text = (desc.subSequence(0, indexSp)).toString(),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(10.dp)
                )

                Text(
                    text = (desc.subSequence(indexSp + 1, desc.length)).toString(),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp)
                )

            }

        }



        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Button(
                onClick = {

                }
            ) {
                Text("Previous")
            }
            Button(
                onClick = {

                }
            ) {
                Text("Next")
            }
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun PhotoAppPreview() {
    PhotoAppLayout()
}