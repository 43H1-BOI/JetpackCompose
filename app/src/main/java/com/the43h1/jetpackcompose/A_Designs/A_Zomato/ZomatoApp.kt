package com.the43h1.jetpackcompose.A_Designs.A_Zomato

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.A_Designs.A_Zomato.Database.BannerData
import com.the43h1.jetpackcompose.R
import com.the43h1.jetpackcompose.ui.theme.Orange
import com.the43h1.jetpackcompose.ui.theme.White

//@Preview(showSystemUi = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ZomatoApp() {
    Scaffold(
        /** Top App Bar */
        topBar = {
            TopAppBar(
                title = {
                    Spacer(
                        modifier = Modifier
                            .width(8.dp)
                    )
                    Text(
                        text = "Zomato",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        fontFamily = FontFamily.SansSerif,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                actions = {
                    Icon(
                        painter = painterResource(R.drawable.pfp_51_super),
                        contentDescription = "Profile Menu",
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .size(35.dp)
                            .clip(CircleShape)
                    )
                },
                colors = TopAppBarColors(
                    containerColor = Orange,
                    scrolledContainerColor = Orange,
                    navigationIconContentColor = White,
                    titleContentColor = White,
                    actionIconContentColor = White
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

        }
    }
}

@Composable
fun BannersScreen(bannerData: BannerData = BannerData(R.drawable.large_62_super, "Spider Man")) {
    Card(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .height(170.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = painterResource(bannerData.imageId),
            contentDescription = bannerData.imageDetails,
            contentScale = ContentScale.Crop,
        )
    }
}