package com.the43h1.jetpackcompose.D_Layout_Composables

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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
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
        verticalArrangement = Arrangement.SpaceEvenly
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
            .statusBarsPadding()
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
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
        val center = ConstrainedLayoutReference(R.string.center)

        // Links B/W Two
        val topLAndTopR = ConstrainedLayoutReference(R.string.topLAndTopR)
        val topLAndBottomL = ConstrainedLayoutReference(R.string.topLAndBottomL)
        val topRAndBottomR = ConstrainedLayoutReference(R.string.topRAndBottomR)
        val bottomLAndBottomR = ConstrainedLayoutReference(R.string.bottomLAndBottomR)

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
                },
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif
            )

            Text(
                stringResource(R.string.topRight), // or this
                modifier = Modifier.constrainAs(topRight) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                },
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif
            )

            Text(
                stringResource(R.string.bottomLeft), // or this
                modifier = Modifier.constrainAs(bottomLeft) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                },
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif
            )

            Text(
                stringResource(R.string.bottomRight), // or this
                modifier = Modifier.constrainAs(bottomRight) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                },
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif
            )

            Text(
                stringResource(R.string.center), // or this
                modifier = Modifier.constrainAs(center) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                },
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif
            )



            Text(
                stringResource(R.string.topLAndTopR), // or this
                modifier = Modifier.constrainAs(topLAndTopR) {
                    start.linkTo(topLeft.end)
                    end.linkTo(topRight.start)
                    top.linkTo(parent.top)
                },
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                color = Color.Red
            )


            Text(
                stringResource(R.string.topLAndBottomL), // or this
                modifier = Modifier.constrainAs(topLAndBottomL) {
                    top.linkTo(topLeft.bottom)
                    bottom.linkTo(bottomLeft.top)
                    start.linkTo(parent.start)
                },
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                color = Color.Red
            )


            Text(
                stringResource(R.string.topRAndBottomR), // or this
                modifier = Modifier.constrainAs(topRAndBottomR) {
                    top.linkTo(topRight.bottom)
                    bottom.linkTo(bottomRight.top)
                    end.linkTo(parent.end)
                },
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                color = Color.Red
            )


            Text(
                stringResource(R.string.bottomLAndBottomR), // or this
                modifier = Modifier.constrainAs(bottomLAndBottomR) {
                    start.linkTo(bottomLeft.end)
                    end.linkTo(bottomRight.start)
                    bottom.linkTo(parent.bottom)
                },
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif,
                color = Color.Red
            )





        }


    }
}

@Preview(showSystemUi = true)
@Composable
fun ExPreview() {
//    BoxRowColumnLayout()
    ConstraintsEx()
}


@Composable
fun BoxRowColumnLayout() { // This is for Box,Row,Column Layout Combined Preview
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Row {
            Column {
                Text(
                    "Column",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
                ColumnEx()
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    "Box",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                BoxEx()
            }
        }
        Column {
            Text(
                "Row",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            RowEx()
        }

    }
}