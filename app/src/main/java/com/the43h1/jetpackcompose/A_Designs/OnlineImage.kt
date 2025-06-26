package com.the43h1.jetpackcompose.A_Designs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.transform.BlurTransformation
import coil.transform.CircleCropTransformation
import com.the43h1.jetpackcompose.R

@OptIn(ExperimentalCoilApi::class)
@Composable
fun OnlineImageEx() {
    val painter = rememberImagePainter(
        data = "https://images.unsplash.com/photo-1657632843433-e6a8b7451ac6?q=80&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        builder = {
            transformations(
                BlurTransformation(LocalContext.current.applicationContext),
                CircleCropTransformation(),
            )
            this.error(R.drawable.baatman)

            // While image is Not Loaded
            placeholder(R.drawable.fruits)

            crossfade(1000)

//            addHeader("Image Ring", "H")
        }
    )

    val painterState = painter.state

    Image(painter, "null")
}

@Preview
@Composable
private fun OnlineImagePreview() {
    Surface {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            OnlineImageEx()
        }
    }
}