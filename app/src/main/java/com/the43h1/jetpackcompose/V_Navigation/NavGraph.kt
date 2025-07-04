package com.the43h1.jetpackcompose.V_Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.the43h1.jetpackcompose.V_Navigation.ScreenDir.DetailsScreen
import com.the43h1.jetpackcompose.V_Navigation.ScreenDir.HomeScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.HomeScreenObj.route) {
        composable(Screen.HomeScreenObj.route) { HomeScreen(navController) }
        composable(Screen.DetailsScreenObj.route) { DetailsScreen(navController) }
    }
}