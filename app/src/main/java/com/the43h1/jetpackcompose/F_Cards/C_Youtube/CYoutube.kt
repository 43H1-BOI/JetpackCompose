package com.the43h1.jetpackcompose.F_Cards.C_Youtube

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.R

@Composable
fun VideoCard(videoDetails: VideoData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Box(modifier = Modifier) {
                Image(
                    painter = painterResource(videoDetails.imgId),
                    contentDescription = videoDetails.videoTitle,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .aspectRatio(16f / 9f)
                        .fillMaxWidth()
                )
                Text(
                    text = videoDetails.videoLength,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    maxLines = 1,
                    color = Color.White,
                    modifier = Modifier
                        .padding(end = 4.dp, bottom = 3.dp)
                        .align(Alignment.BottomEnd)
                        .background(Color.Black)
                )
            }

            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.fillMaxWidth(0.9f)
                ) {
                    Text(
                        text = videoDetails.videoTitle,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        maxLines = 2
                    )
                    Text(
                        text = videoDetails.channelName,
                        maxLines = 1
                    )
                }

                Icon(
                    Icons.Default.MoreVert, "More Options",
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun YoutubeApp() {
    var videoList = listOf<VideoData>(
        VideoData(
            imgId = R.drawable.large_26_super,
            videoTitle = "How to Create a Powerful Suit with Arc Reactor as Power Source",
            videoLength = "01:02:39",
            channelName = "Iron Man"
        ),
        VideoData(
            imgId = R.drawable.large_4_car,
            videoTitle = "Supra in the City | Ultimate Gameplay",
            videoLength = "36:22",
            channelName = "Spidy Ultimate"
        ),
        VideoData(
            imgId = R.drawable.large_10_car,
            videoTitle = "Lamborghini ASMR",
            videoLength = "02:14",
            channelName = "ASMR King"
        ),
        VideoData(
            imgId = R.drawable.large_23_super,
            videoTitle = "Naach mere Bhai | Official Music Video | Spidy x Daredevil",
            videoLength = "12:39",
            channelName = "Spidy Ultimate"
        ),
        VideoData(
            imgId = R.drawable.large_40_super,
            videoTitle = "Spider man and Maashooka ke Jalwe",
            videoLength = "3:41",
            channelName = "Spidy Ultimate"
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        items(videoList) { video ->
            VideoCard(video)
        }
    }
}


//@Preview(showSystemUi = true)
//@Composable
//fun CardPreview() {
//    VideoCard(
//        VideoData(
//            imgId = R.drawable.baatman,
//            videoTitle = "Batman in the City",
//            videoLength = "12:39",
//            channelName = "Spidy Ultimate"
//        )
//    )
//}