package com.the43h1.jetpackcompose.A_Designs.A_Zomato.Database

import androidx.annotation.DrawableRes

data class CardData(
    @DrawableRes var imageId: Int,
    var itemName: String
)