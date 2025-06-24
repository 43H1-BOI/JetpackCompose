package com.the43h1.jetpackcompose.A_Designs.A_Zomato

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.A_Designs.A_Zomato.Database.BannerData
import com.the43h1.jetpackcompose.A_Designs.A_Zomato.Database.CardData
import com.the43h1.jetpackcompose.R
import com.the43h1.jetpackcompose.ui.theme.Orange
import com.the43h1.jetpackcompose.ui.theme.White

@Preview(showSystemUi = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ZomatoApp() {
    val bannerData = listOf<BannerData>(
        BannerData(
            imageId = R.drawable.large_72_super,
            imageDetails = "Spidy Mon Savage"
        ),
        BannerData(
            imageId = R.drawable.large_8_car,
            imageDetails = "Lambo"
        ),
        BannerData(
            imageId = R.drawable.large_63_super,
            imageDetails = "Spidy Mon"
        ),
        BannerData(
            imageId = R.drawable.large_56_car,
            imageDetails = "Mustang"
        ),
        BannerData(
            imageId = R.drawable.large_48_car,
            imageDetails = "Lake"
        )
    )

    var cardItems = listOf<CardData>(
        CardData(
            imageId = R.drawable.pfp_8_car,
            itemName = "Blue Lambo"
        ),
        CardData(
            imageId = R.drawable.pfp_28_car,
            itemName = "SRT"
        ),
        CardData(
            imageId = R.drawable.pfp_72_super,
            itemName = "Cartoon Spidy"
        ),
        CardData(
            imageId = R.drawable.pfp_63_super,
            itemName = "Spidy OG"
        ),
        CardData(
            imageId = R.drawable.pfp_51_car,
            itemName = "DODGE Ch."
        ),
        CardData(
            imageId = R.drawable.pfp_21_car,
            itemName = "HemiCuda"
        ),
        CardData(
            imageId = R.drawable.pfp_13_super,
            itemName = "Fantastic 4"
        ),
        CardData(
            imageId = R.drawable.pfp_36_super,
            itemName = "Teegdi"
        ),
        CardData(
            imageId = R.drawable.pfp_26_super,
            itemName = "IronMan"
        ),
        CardData(
            imageId = R.drawable.pfp_40_super,
            itemName = "SpidyLove"
        )
    )

    var bannerCount: Int = bannerData.count()

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
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            BannersScreen(bannerCount, bannerData)
            Text(
                "CATEGORIES",
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.SansSerif,
                letterSpacing = 1.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    elevation = CardDefaults.cardElevation(10.dp),
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                ) {
                    Image(painterResource(cardItems[0].imageId), cardItems[0].itemName)
                    Text(cardItems[0].itemName)
                }
                Card(
                    elevation = CardDefaults.cardElevation(10.dp),
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                ) {
                    Image(painterResource(cardItems[1].imageId), cardItems[1].itemName)
                    Text(cardItems[1].itemName)
                }
                Card(
                    elevation = CardDefaults.cardElevation(10.dp),
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                ) {
                    Image(painterResource(cardItems[2].imageId), cardItems[2].itemName)
                    Text(cardItems[2].itemName)
                }
            }

        }
    }
}

@Composable
private fun BannersScreen(
    bannerCount: Int,
    bannerData: List<BannerData>
) {
    LazyRow(
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        items(bannerCount) { idx ->
            Card(
                modifier = Modifier
                    .padding(vertical = 16.dp, horizontal = 8.dp)
                    .height(170.dp)
                    .width(345.dp)
                    .clip(RoundedCornerShape(16.dp))
            ) {
                Image(
                    painter = painterResource(bannerData[idx].imageId),
                    contentDescription = bannerData[idx].imageDetails,
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Composable
private fun OneBannerScreen(
    bannerData: BannerData = BannerData(R.drawable.large_62_super, "Spider Man"),
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .height(170.dp)
            .width(345.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = painterResource(bannerData.imageId),
            contentDescription = bannerData.imageDetails,
            contentScale = ContentScale.Crop
        )
    }
}