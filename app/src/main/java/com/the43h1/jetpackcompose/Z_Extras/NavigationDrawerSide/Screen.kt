package com.the43h1.jetpackcompose.Z_Extras.NavigationDrawerSide

sealed class Screen(val screen: String) {
    data object Home : Screen("home")
    data object Profile : Screen("profile")
    data object Settings : Screen("settings")
    data object Notifications : Screen("notification")
}