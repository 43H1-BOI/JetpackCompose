package com.the43h1.jetpackcompose.J_Floating_Action_Button

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
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

@Composable
fun FloatingBasics() {
    var isExpanded by remember {
        mutableStateOf(false)
    }

    var context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .statusBarsPadding()
            .navigationBarsPadding(),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingActionButton(
            onClick = {
                if (isExpanded) {
                    // TODO : Fix This Piece of Code
//                    ExtraButtons(
//                        Icon(Icons.Default.Build, null),
//                        Toast.makeText(context, "Build Button is Clicked", Toast.LENGTH_SHORT)
//                            .show()
//                    )
                } else {

                }
            }, modifier = Modifier
                .padding(20.dp),
//            containerColor = TODO(),
//            contentColor = TODO(),
//            elevation = TODO(),
//            interactionSource = TODO(),
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

@Composable
fun ExtraButtons(content: () -> Unit, onClick: () -> Unit) {
    FloatingActionButton(
        onClick = {
            onClick
        },
        modifier = Modifier
            .padding(20.dp),
        shape = CircleShape,
        content = {
            content
        }
    )
}

@Preview(showSystemUi = true)
@Composable
fun FloatingBasicsPreview() {
    FloatingBasics()
}