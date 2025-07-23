package com.the43h1.jetpackcompose.A_Google.D_Affirmation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    @StringRes val stringRes: Int,
    @DrawableRes val imageRes: Int
)