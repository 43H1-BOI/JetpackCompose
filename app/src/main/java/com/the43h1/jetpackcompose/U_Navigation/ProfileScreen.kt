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

@Composable
fun ProfileScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "This is Profile Screen",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.DarkGray
        )
        Button(
            onClick = {
                navController.navigate("HomeS")
                // HomeS is Keyword for HomeScreen()

//                navController.popBackStack(  // not working
//                    route = "HomeS",
//                    inclusive = false // true means on last screen
//                )
            }
        ) {
            Text("Go To Home Screen")
        }
    }
}