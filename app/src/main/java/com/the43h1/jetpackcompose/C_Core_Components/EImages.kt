package com.the43h1.jetpackcompose.C_Core_Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.the43h1.jetpackcompose.R

@Composable
fun ImageEditor() {
    var rainbow = listOf(
        colorResource(R.color.violet),
        colorResource(R.color.indigo),
        colorResource(R.color.blue),
        colorResource(R.color.green),
        colorResource(R.color.yellow),
        colorResource(R.color.orange),
        colorResource(R.color.red),
    )

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .background(brush = Brush.linearGradient(rainbow)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.baatman),
            contentDescription = null,
            modifier = Modifier
                .border(width = 2.dp, Color.Black),
            // opacity
            alpha = 0.75f,
            contentScale = ContentScale.Fit
        )

        Image(
            painter = painterResource(R.drawable.not_allowed),
            contentDescription = null,
            modifier = Modifier
                .size(400.dp)
                .align(Alignment.CenterHorizontally)
                .scale(1.5f)
                .alpha(0.9f)
        )

        Image(
            painter = painterResource(R.drawable.not_allowed),
            contentDescription = null,
            modifier = Modifier
                .border(
                    width = 5.dp,
                    color = Color.Green,
                    shape = RoundedCornerShape(corner = CornerSize(20.dp))
                )
                .clip(shape = RoundedCornerShape(20.dp))
        )

    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewImages() {
    ImageEditor()
}