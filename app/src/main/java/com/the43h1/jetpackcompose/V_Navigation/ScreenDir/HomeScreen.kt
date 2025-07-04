package com.the43h1.jetpackcompose.V_Navigation.ScreenDir

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.the43h1.jetpackcompose.V_Navigation.Screen

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                navController.navigate(Screen.DetailsScreenObj.route) {
                    popUpTo(Screen.DetailsScreenObj.route) {
                        inclusive = true
                    }
                }
            }
    ) {
        Text(
            "Home Screen",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.Magenta
        )
    }
}