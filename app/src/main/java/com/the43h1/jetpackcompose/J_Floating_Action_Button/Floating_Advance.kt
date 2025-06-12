package com.the43h1.jetpackcompose.J_Floating_Action_Button

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun FloatingAdvance() {
    var isExpanded by remember {
        mutableStateOf(false)
    }

    var context = LocalContext.current


    Box(
        modifier = Modifier
            .fillMaxSize()
//            .padding(20.dp)
            .statusBarsPadding()
            .navigationBarsPadding(),
    ) {
        Column(
            modifier = Modifier
                .size(width = 70.dp, height = 300.dp)
                .align(Alignment.BottomEnd)
                .navigationBarsPadding(),
        ) {
//        AnimatedVisibility(
//            visible = isExpanded,
//            enter = expandHorizontally(
//                expandFrom = Alignment.End
//            ),
//            exit = shrinkHorizontally(
//                shrinkTowards = Alignment.Start
//            ),
//            content = {
            if (!isExpanded) {
                ExtraButtons(
                    content = {
                        Icon(Icons.Default.Build, null)
                    }, onClick = {
                        Toast.makeText(
                            context,
                            "Building Started",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    modifier = Modifier
                        .padding(top = 10.dp)
                )
                ExtraButtons(
                    content = {
                        Icon(Icons.Default.DateRange, null)
                    }, onClick = {

                        var sdf = SimpleDateFormat()

                        Toast.makeText(
                            context,
                            "${sdf.format(Date())}",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    modifier = Modifier
                        .padding(top = 10.dp)
                )
                ExtraButtons(
                    content = {
                        Icon(Icons.Default.FavoriteBorder, null)
                    }, onClick = {
                        Toast.makeText(
                            context,
                            "Love You Too !",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                    modifier = Modifier
                        .padding(top = 10.dp)
                )
            }
//        )

            FloatingActionButton(
                onClick = {
                    isExpanded = !isExpanded
                }, modifier = Modifier
                    .padding(bottom = 10.dp, top = 10.dp),
                shape = CircleShape,
                content = {
                    if (isExpanded)
                        Icon(Icons.Default.Add, null)
                    else
                        Icon(Icons.Default.Close, null)
                }
            )

        }
    }
}

@Composable
fun ExtraButtons(
    content: @Composable () -> Unit, onClick: () -> Unit,
    modifier: Modifier = Modifier
        .padding(20.dp),
) {
    FloatingActionButton(
        onClick = {
            onClick
        },
        modifier = modifier,
        shape = CircleShape,
        content = {
            content
        }
    )
}

@Preview(showSystemUi = true)
@Composable
fun FloatingAdvancePreview() {
    FloatingAdvance()
}

// Todo :
//  Logo not Added Completely
//  Not Collapsing in Down Direction