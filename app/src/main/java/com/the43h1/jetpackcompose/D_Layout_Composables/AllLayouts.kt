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

// Constraint Layout is Very Complex and Resource Heavy
// Only use when needed
// dependencies are needed for this one
@Composable
fun ConstraintsEx() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Creating Reference
//        val (text1,text2,text3,text4) =  createRefs() // Not Working :?
        val topLeft = ConstrainedLayoutReference(R.string.topLeft)
        val topRight = ConstrainedLayoutReference(R.string.topRight)
        val bottomLeft = ConstrainedLayoutReference(R.string.bottomLeft)
        val bottomRight = ConstrainedLayoutReference(R.string.bottomRight)

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {
            Text(
                "Top Left", // can use this
                modifier = Modifier.constrainAs(topLeft) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
            )

            Text(
                stringResource(R.string.topRight), // or this
                modifier = Modifier.constrainAs(topRight) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
            )

            Text(
                stringResource(R.string.bottomLeft), // or this
                modifier = Modifier.constrainAs(bottomLeft) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
            )

            Text(
                stringResource(R.string.bottomRight), // or this
                modifier = Modifier.constrainAs(bottomRight) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
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




