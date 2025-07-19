package com.the43h1.jetpackcompose.A_Google.C_Layout

import androidx.annotation.DrawableRes
import com.the43h1.jetpackcompose.R

data class CardDetails(
    @DrawableRes val image: Int,
    val title: String
)

var AlignList = listOf<CardDetails>(
    CardDetails(R.drawable.ab1_inversions, "Inversions"),
    CardDetails(R.drawable.ab2_quick_yoga, "Quick yoga"),
    CardDetails(R.drawable.ab3_stretching, "Stretching"),
    CardDetails(R.drawable.ab4_tabata, "Tabata"),
    CardDetails(R.drawable.ab5_hiit, "Hit"),
    CardDetails(R.drawable.ab6_pre_natal_yoga, "Pre natal yoga")
)

var FavList = listOf<CardDetails>(
    CardDetails(R.drawable.fc1_short_mantras, "Short Mantras"),
    CardDetails(R.drawable.fc2_nature_meditations, "Nature meditations"),
    CardDetails(R.drawable.fc3_stress_and_anxiety, "Stress and Anxiety"),
    CardDetails(R.drawable.fc4_self_massage, "Self massage"),
    CardDetails(R.drawable.fc5_overwhelmed, "Overwhelmed"),
    CardDetails(R.drawable.fc6_nightly_wind_down, "Nightly wind down")
)