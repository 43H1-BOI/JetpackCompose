package com.the43h1.jetpackcompose.A_Google.C_Layout

import androidx.annotation.DrawableRes
import com.the43h1.jetpackcompose.R

data class AlignBodyCardDetails(
    @DrawableRes val image: Int,
    val title: String
)

var AlignList = listOf<AlignBodyCardDetails>(
    AlignBodyCardDetails(R.drawable.ab1_inversions, "Inversions"),
    AlignBodyCardDetails(R.drawable.ab2_quick_yoga, "Quick yoga"),
    AlignBodyCardDetails(R.drawable.ab3_stretching, "Stretching"),
    AlignBodyCardDetails(R.drawable.ab4_tabata, "Tabata"),
    AlignBodyCardDetails(R.drawable.ab5_hiit, "Hit"),
    AlignBodyCardDetails(R.drawable.ab6_pre_natal_yoga, "Pre natal yoga")
)