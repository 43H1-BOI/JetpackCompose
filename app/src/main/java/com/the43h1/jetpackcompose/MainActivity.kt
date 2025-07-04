package com.the43h1.jetpackcompose

//import com.the43h1.jetpackcompose.M_Navigation_Drawer.NavBottomDrawer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.the43h1.jetpackcompose.U_Navigation.MainScreen
import com.the43h1.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTheme {
                MainScreen()
            }
        }
    }
}