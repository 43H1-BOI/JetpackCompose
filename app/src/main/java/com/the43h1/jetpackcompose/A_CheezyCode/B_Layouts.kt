package com.the43h1.jetpackcompose.A_CheezyCode

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.R

// Arranged On Top of Each Other
@Composable
fun BoxLayoutEx() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.palm), null,
            modifier = Modifier
                .fillMaxSize()
                .blur(50.dp),
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(R.drawable.lotus), null,
            alpha = 0.5f,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

// Arranged Vertically
@Composable
fun RowLayoutEx() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            "My Name is",
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            color = Color.Red
        )
        Text(
            "Abhishek Yadav",
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            color = Color.Green
        )
    }
}

// Arranged Horizontally
@Composable
fun ColumnLayoutEx() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            "My Name is",
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            color = Color.Magenta
        )
        Text(
            "Abhishek Yadav",
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            color = Color.Cyan
        )
    }
}

// Used Every Layout
@Composable
fun ContactCard(imgId: Int, imgDesc: String?, name: String, occupation: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
            modifier = Modifier
                .background(color = Color.LightGray, shape = RectangleShape)
                .fillMaxWidth()
                .padding(8.dp)
//                .height(80.dp)
        ) {
            // Image of Contact
            Image(
                painter = painterResource(imgId),
                contentDescription = imgDesc,
                modifier = Modifier
                    .size(45.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
            ) {
                // Name of Contact
                Text(
                    name,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
                // Detail of Contact
                Text(
                    occupation,
                    fontWeight = FontWeight.ExtraLight,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LayoutsPreview() {
//    ColumnLayoutEx()
//    RowLayoutEx()
//    BoxLayoutEx()
    ContactCard(
        imgId = R.drawable.monkey,
        imgDesc = null,
        name = "Monkey Bhai Ji",
        occupation = "Messenger of Hanuman Ji"
    )
}