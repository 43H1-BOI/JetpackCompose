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


data class FavBodyCardDetails(
    @DrawableRes val image: Int,
    val title: String
)

var FavList = listOf<FavBodyCardDetails>(
    FavBodyCardDetails(R.drawable.fc1_short_mantras, "Short Mantras"),
    FavBodyCardDetails(R.drawable.fc2_nature_meditations, "Nature meditations"),
    FavBodyCardDetails(R.drawable.fc3_stress_and_anxiety, "Stress and Anxiety"),
    FavBodyCardDetails(R.drawable.fc4_self_massage, "Self massage"),
    FavBodyCardDetails(R.drawable.fc5_overwhelmed, "Overwhelmed"),
    FavBodyCardDetails(R.drawable.fc6_nightly_wind_down, "Nightly wind down")
)