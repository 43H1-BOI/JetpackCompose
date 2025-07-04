package com.the43h1.jetpackcompose

//import com.the43h1.jetpackcompose.M_Navigation_Drawer.NavBottomDrawer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.the43h1.jetpackcompose.V_Navigation.NavGraph
import com.the43h1.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lateinit var navController: NavController
        enableEdgeToEdge()
        setContent {
            navController = rememberNavController()

            JetpackComposeTheme {
                NavGraph(navController)
            }
        }
    }
}