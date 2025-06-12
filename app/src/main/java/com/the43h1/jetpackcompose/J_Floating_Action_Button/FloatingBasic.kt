package com.the43h1.jetpackcompose.J_Floating_Action_Button

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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

        Button(
            onClick = {
                isExpanded = !isExpanded
            },
            modifier = Modifier
                .padding(bottom = 500.dp)
        ) { Text("Toggle Button") }

        FloatingActionButton(
            onClick = {
                Toast.makeText(context, "Build Button is Clicked", Toast.LENGTH_SHORT)
                    .show()
                isExpanded = !isExpanded
            }, modifier = Modifier
                .padding(20.dp),
            shape = CircleShape,
            content = {
                AnimatedVisibility(isExpanded) {
                    Icon(Icons.Default.Add, null)
                }
                AnimatedVisibility(!isExpanded) {
                    Icon(Icons.Default.Close, null)
                }
            }
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun FloatingBasicsPreview() {
    FloatingBasics()
}