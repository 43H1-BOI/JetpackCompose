package com.the43h1.jetpackcompose.U_Navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "HomeS") {
        composable("HomeS") { HomeScreen(navController) }
        // HomeS is Keyword for HomeScreen()

        composable("ProfileS") { ProfileScreen(navController) }
        // ProfileS is Keyword for ProfileScreen()
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "This is Home Screen",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.Blue
        )
        Button(
            onClick = {
                // The Above Method is Used in General but major Drawback About it is
                // If we call back button then it will send us to back screen and will not exit us from app
//                navController.popBackStack( // not working
//                    route = "ProfileS",
//                    inclusive = false // false means exit app
//                )
                navController.navigate("ProfileS")
                // ProfileS is Keyword for ProfileScreen()
            }
        ) {
            Text("Go To Profile Screen")
        }
    }
}