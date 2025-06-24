package com.the43h1.jetpackcompose.A_Designs.A_Zomato.Database

import androidx.annotation.DrawableRes

data class BannerData(
    @DrawableRes var imageId: Int,
    var imageDetails: String
)