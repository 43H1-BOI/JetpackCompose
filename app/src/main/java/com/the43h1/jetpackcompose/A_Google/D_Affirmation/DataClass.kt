package com.the43h1.jetpackcompose.A_Google.D_Affirmation

import com.the43h1.jetpackcompose.R

// object b'coz want to instantiate this once
object DataClass {
    fun getList(): List<Affirmation> {
        return listOf(
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation2, R.drawable.image2),
            Affirmation(R.string.affirmation3, R.drawable.image3),
            Affirmation(R.string.affirmation4, R.drawable.image4),
            Affirmation(R.string.affirmation5, R.drawable.image5)
        )
    }
}