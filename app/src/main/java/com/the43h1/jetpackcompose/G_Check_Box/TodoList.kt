package com.the43h1.jetpackcompose.G_Check_Box

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.R

@Composable
fun TodoApp() {
    var todoList =
        mutableListOf<String>(
            "Kotlin", "Android Basics", "Jetpack Compose", "SQLite DB", "DSA"
        )

    // ( size ){ each item marked false }
    var checkedState =
        remember { mutableStateListOf<Boolean>(*Array(todoList.size) { false }) }

    // Context for Toast
    var context = LocalContext.current.applicationContext

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.skyBlue))
            .padding(20.dp)
    ) {
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .size(700.dp)
                .border(
                    border = BorderStroke(
                        width = 5.dp,
                        color = colorResource(R.color.blue)
                    ),
                    shape = RectangleShape
                )
//                .padding(40.dp)
//                .clip(shape = RectangleShape)
        ) {
            Text(
                "Todo List App",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 10.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center
            )

            LazyColumn(
                modifier = Modifier
                    .statusBarsPadding()
                    .size(700.dp)
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            )
            {
                // For Displaying Each Items from the List
                itemsIndexed(todoList) { index, items ->

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    // Contains Box and Text in Row
                    {

                        Checkbox(
                            checked = checkedState[index],
                            onCheckedChange = {
                                checkedState[index] = it

                            },
                            modifier = Modifier
                                .size(25.dp)
                                .padding(start = 10.dp, end = 10.dp)
                                .align(Alignment.CenterVertically)
                        )

                        Text(
                            items,
                            modifier = Modifier.padding(start = 10.dp),
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 25.sp,
                            maxLines = 2
                        )
                    }
                }
            }

// TODO : Will do this Later
//            TextField(
//                value = "Add Task",
//                onValueChange = {
//                    if (it != "") {
//                        todoList.add(it)
//                    }
//                },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(20.dp)
////                , keyboardOptions = KeyboardOptions()
//            )
        }
    }
}


@Composable
fun NeonShape() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp)
    ) {
        val paint = remember {
            Paint().apply {
                style = PaintingStyle.Stroke
                strokeWidth = 30f
            }
        }

        val frameworkPaint = remember {
            paint.asFrameworkPaint()
        }

        val color = colorResource(R.color.skyBlue)

        val transparent = color
            .copy(alpha = 0f)
            .toArgb()


        frameworkPaint.also {
            it.color = transparent

            it.setShadowLayer(
                10f, 0f, 0f,
                color
                    .copy(alpha = .5f)
                    .toArgb()
            )
        }

        Canvas(modifier = Modifier.fillMaxSize()) {
            inset(10.dp.toPx()) {
                this.drawIntoCanvas {
                    it.drawRoundRect(
                        left = 0f,
                        top = 0f,
                        right = size.width,
                        bottom = size.height,
                        radiusX = 5.dp.toPx(),
                        5.dp.toPx(),
                        paint = paint
                    )

                    drawRoundRect(
                        Color.White,
                        cornerRadius = CornerRadius(5.dp.toPx(), 5.dp.toPx()),
                        style = Stroke(width = 2.dp.toPx())
                    )
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun NeonPreview() {
//    NeonShape()
    TodoApp()
}
