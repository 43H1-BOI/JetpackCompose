package com.the43h1.jetpackcompose.A_Practice_Apps

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.R

@Composable
fun PhotoAppLayout() {
    var imageDesc = mapOf<Painter, String>(
        painterResource(R.drawable.fruits) to "4 Fruits |Abhishek Yadav> (2025)",
//        painterResource(R.drawable.pinkflower) to "These are Pink Flowers",
//        painterResource(R.drawable.palm) to "This is Palm Tree",
//        painterResource(R.drawable.monkey) to "This is Hanumanth"
    )

    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
//            .background(Color.Red)
            .padding(20.dp)
            .statusBarsPadding()
    ) {

        for ((image, desc) in imageDesc) {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .size(700.dp, 450.dp)
                    .padding(10.dp)
//                    .border(border = BorderStroke(3.dp,Color.LightGray))
                    .shadow(3.dp)
//                    .clip(RoundedCornerShape(2f))
            )

            // Index of | character which separates Image Description and Owner of Image
            var indexSp = desc.indexOf('|')

            // Index of > character which separates Owner of Image and Year
            var indexSp2 = desc.indexOf('>')

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(10.dp)
            ) {
                Text(
                    text = (desc.subSequence(0, indexSp)).toString(),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier
//                        .padding(3.dp)
                )

                // Image Description and Owner
                Row {
                    Text(
                        text = (desc.subSequence(indexSp + 1, indexSp2)).toString(),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier
//                        .padding(top = 5.dp, bottom = 5.dp)
                    )
                    Text(
                        text = (desc.subSequence(indexSp2 + 1, desc.length)).toString(),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier
//                        .padding(top = 5.dp, bottom = 5.dp)
                    )
                }
            }
        }

        // Buttons
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

                },
                modifier = Modifier
//                    .padding(start = 10.dp, end = 10.dp)
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