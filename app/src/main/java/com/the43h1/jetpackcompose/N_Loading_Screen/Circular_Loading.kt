package com.the43h1.jetpackcompose.N_Loading_Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CircLoading() {
    var inProgress by remember {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(top = 200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(50.dp)
    ) {
        Button(
            onClick = {
                inProgress = true
            },
            enabled = !inProgress
        ) {
            Text("Start Loading")
        }

        if (inProgress) {
            CircularProgressIndicator(
                modifier = Modifier.width(64.dp),
                color = MaterialTheme.colorScheme.onPrimary,
                trackColor = MaterialTheme.colorScheme.primary
            )
        }

        Button(
            onClick = {
                inProgress = false
            },
            enabled = inProgress
        ) {
            Text("Stop Loading")
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun CircPreview(){
    CircLoading()
}