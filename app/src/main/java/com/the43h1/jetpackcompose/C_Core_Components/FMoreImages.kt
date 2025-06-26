package com.the43h1.jetpackcompose.C_Core_Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.the43h1.jetpackcompose.R

@Composable
fun MoreImagesEx() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = painterResource(R.drawable.fruits),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.aspectRatio(16f / 9f)
        )

        Image(
            painter = painterResource(R.drawable.baatman),
            contentDescription = null,

            contentScale = ContentScale.Crop,
            modifier = Modifier
//                .aspectRatio(16f / 9f)
                .clip(CircleShape)
//                .padding(10.dp)
        )
    }
}

/*
// TODO
//    Internet Image Not Working
//
//@Composable
//fun InternetImage() {
////    Box(
////        modifier = Modifier
////            .fillMaxSize()
////    ) {
////        AsyncImage(
////            model = "https://images.contentstack.io/v3/assets/bltcedd8dbd5891265b/blt5f18c2119ce26485/6668df65db90945e0caf9be6/beautiful-flowers-lotus.jpg?q=70&width=1920&auto=webp",
////            contentDescription = null,
////            modifier = Modifier
////                .padding(20.dp)
//////                .clip(CircleShape)
////        )
//    AsyncImage(
//        model = ImageRequest.Builder(LocalContext.current)
//            .data("https://images.contentstack.io/v3/assets/bltcedd8dbd5891265b/blt5f18c2119ce26485/6668df65db90945e0caf9be6/beautiful-flowers-lotus.jpg?q=70&width=1920&auto=webp")
//            .build(),
//        contentDescription = null,
//        contentScale = ContentScale.Crop,
//        modifier = Modifier.clip(CircleShape),
//    )
////    }
//}
*/


@Preview(showSystemUi = true)
@Composable
fun MoreImagePreview() {
//    MoreImagesEx()
//    InternetImage()
}