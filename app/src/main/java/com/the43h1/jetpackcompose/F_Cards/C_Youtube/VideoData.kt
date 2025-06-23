package com.the43h1.jetpackcompose.F_Cards.C_Youtube

import androidx.annotation.DrawableRes

data class VideoData(
    @DrawableRes val imgId: Int,
    val videoTitle: String,
    val videoLength: String,
    val channelName: String
)