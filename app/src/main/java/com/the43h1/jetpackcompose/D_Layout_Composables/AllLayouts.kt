package com.the43h1.jetpackcompose.D_Layout_Composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.R

// Column means ek ke niche ek
// Row
// Box

@Composable
fun ColumnEx() {
    Column(
        modifier = Modifier
//            .padding(10.dp)
            .statusBarsPadding(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Image(
            painter = painterResource(R.drawable.not_allowed),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )

        Image(
            painter = painterResource(R.drawable.not_allowed),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )

        Image(
            painter = painterResource(R.drawable.not_allowed),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
    }
}

@Composable
fun RowEx() {
    Row(
        modifier = Modifier
//            .padding(10.dp)
            .statusBarsPadding(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Image(
            painter = painterResource(R.drawable.not_allowed),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )

        Image(
            painter = painterResource(R.drawable.not_allowed),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )

        Image(
            painter = painterResource(R.drawable.not_allowed),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
    }
}

@Composable
fun BoxEx() {
    Box(
        modifier = Modifier
//            .padding(10.dp)
            .statusBarsPadding()
            .size(200.dp)
            .background(color = Color.Blue),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color = Color.Red)
        )
        {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(color = Color.Yellow)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ExPreview() {
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Column {
            Text(
                "Column Block",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold
            )
            ColumnEx()
        }

        Column {
            Text(
                "Row Block",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold
            )
            RowEx()
        }

        Column {
            Text(
                "Box Block",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold
            )
            BoxEx()
        }
    }

}




