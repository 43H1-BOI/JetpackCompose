package com.the43h1.jetpackcompose.A_Practice_Apps.Movies_8

sealed class Screen(val screenName: String) {
    data object HomePage : Screen("home")
    data object FavoritePage : Screen("Favorite")
    data object ProfilePage : Screen("Profile")
}