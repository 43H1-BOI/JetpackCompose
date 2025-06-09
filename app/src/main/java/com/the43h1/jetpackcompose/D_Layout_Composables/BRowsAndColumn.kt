package com.the43h1.jetpackcompose.D_Layout_Composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.R

@Composable
fun LazyColumnEx() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.green)),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "This is Outside Lazy Column",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan),
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )


        //Lazy Column for Texts
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(color = colorResource(R.color.black))
        ) {
            items(100) { index ->
                Text(
                    "This is Column ${index + 1}",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )
            }
        }

        Spacer(Modifier.size(50.dp))
        Text(
            "This is Outside Images Lazy Column",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan),
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )

        // Lazy Column for Images
//        Image(painter = painterResource(R.drawable.pinkflower), contentDescription = null)
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(color = colorResource(R.color.black)),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(5) {
                Image(painter = painterResource(R.drawable.fruits), contentDescription = null)
                Spacer(Modifier.size(20.dp))

                Image(painter = painterResource(R.drawable.monkey), contentDescription = null)
                Spacer(Modifier.size(20.dp))

                Image(painter = painterResource(R.drawable.lotus), contentDescription = null)
                Spacer(Modifier.size(20.dp))

                Image(painter = painterResource(R.drawable.palm), contentDescription = null)
                Spacer(Modifier.size(20.dp))

                Image(painter = painterResource(R.drawable.whiteflower), contentDescription = null)
                Spacer(Modifier.size(20.dp))
            }
        }
    }
}

@Composable
fun LazyRowEx() {
    Column(
        modifier = Modifier
            .statusBarsPadding()
    ) {
        Text(
            "This is Outside Lazy Row",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan),
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black),
            horizontalArrangement = Arrangement.Center
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Red)
            ) {
                items(100) { index ->
                    Text(
                        "This is Line ${index + 1}    ",
                        color = Color.Cyan,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun ThisPreview() {
//    LazyColumnEx()
//    LazyRowEx()
}