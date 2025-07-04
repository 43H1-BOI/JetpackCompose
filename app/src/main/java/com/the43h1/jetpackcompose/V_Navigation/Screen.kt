package com.the43h1.jetpackcompose.V_Navigation

sealed class Screen(val route : String){
    data object HomeScreenObj : Screen("home_screen")
    data object DetailsScreenObj : Screen("detail_screen")
}