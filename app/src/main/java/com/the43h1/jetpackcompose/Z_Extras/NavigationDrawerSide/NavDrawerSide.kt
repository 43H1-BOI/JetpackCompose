package com.the43h1.jetpackcompose.Z_Extras.NavigationDrawerSide

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.the43h1.jetpackcompose.R
import com.the43h1.jetpackcompose.Z_Extras.NavigationDrawerSide.Screens.HomeScreen
import com.the43h1.jetpackcompose.Z_Extras.NavigationDrawerSide.Screens.NotificationsScreen
import com.the43h1.jetpackcompose.Z_Extras.NavigationDrawerSide.Screens.ProfileScreen
import com.the43h1.jetpackcompose.Z_Extras.NavigationDrawerSide.Screens.SettingsScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

private const val appName = "Backup App"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NavDrawerSide() {
    // Used in Navigating from one screen to other
    var navigationController = rememberNavController()

    // Drawer State ( is opened or closed )
    var sideDrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    // Coroutine Scope
    // For changing values of sideDrawerState
    var coroutineScope = rememberCoroutineScope()

    // Context for Toast Message
    val context = LocalContext.current.applicationContext

    ModalNavigationDrawer(
        drawerState = sideDrawerState,
        drawerContent = {
            // A Whole Different Function for Drawer Contents
            DrawerContent(coroutineScope, sideDrawerState, navigationController)
        },
        gesturesEnabled = true,
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        Box(
            modifier = Modifier
                .statusBarsPadding()
                .navigationBarsPadding()
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        listOf<Color>(
                            Color.White,
                            colorResource(R.color.skyBlue),
                            colorResource(R.color.my_light_primary),
                            Color.Black
                        ), tileMode = TileMode.Clamp
                    )
                )
        ) {
            // Top App Bar
            TopAppBar(
                title = {
                    Text("Backup App")
                },
                navigationIcon = {
                    Icon(
                        Icons.Default.Menu, "Menu",
                        modifier = Modifier
                            .size(dimensionResource(R.dimen.icon_size))
                            .clickable {
                                coroutineScope.launch {
                                    sideDrawerState.open()
                                }
                            }
                    )
                },
                actions = {
                    Icon(
                        Icons.Default.Notifications, "Notifications",
                        modifier = Modifier
                            .size(dimensionResource(R.dimen.icon_size))
                            .clickable {
                                navigationController.navigate(Screen.Notifications.screen)
                            }
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Icon(
                        Icons.Default.Person, "Profile",
                        modifier = Modifier
                            .size(dimensionResource(R.dimen.icon_size))
                            .clickable {
                                navigationController.navigate(Screen.Profile.screen) { popUpTo(0) }
                            }
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Icon(
                        Icons.Default.MoreVert, "More Options",
                        modifier = Modifier
                            .size(dimensionResource(R.dimen.icon_size))
                            .clickable {
                                Toast.makeText(context, "Notifications Screen", Toast.LENGTH_SHORT)
                                    .show()
                            }
                    )
                }
            )

            Column {

                // Remaining Part of Nav Drawer
                // This will call the corresponding composable function for same path
                NavHost(
                    navController = navigationController,
                    startDestination = Screen.Home.screen
                ) {
                    composable(Screen.Home.screen) { HomeScreen() }
                    composable(Screen.Profile.screen) { ProfileScreen() }
                    composable(Screen.Notifications.screen) { NotificationsScreen() }
                    composable(Screen.Settings.screen) { SettingsScreen() }
                }
            }
        }
    }
}

@Composable
private fun DrawerContent(
    coroutineScope: CoroutineScope,
    sideDrawerState: DrawerState,
    navigationController: NavHostController
) {
    // Required to Create a Drawer Sheet More Efficient and Ui Responsive
    ModalDrawerSheet(modifier = Modifier.fillMaxWidth(0.7f)) {
        Column {
            // Header of Nav Drawer
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(60.dp)
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.baseline_backup_24),
                    contentDescription = "App Logo",
                    modifier = Modifier.size(25.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    appName,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    fontSize = 20.sp
                )
            }

            // All Drawer Items
            NavigationDrawerItem(
                label = {
                    Text(
                        "Home",
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                },
                selected = false,
                onClick = {
                    // To Close Drawer when we click on any item
                    coroutineScope.launch {
                        sideDrawerState.apply {
                            close()
                        }
                    }
                    // Navigating to Home Screen { Ctrl+9 to Navigate to Remaining Code }
                    navigationController.navigate(Screen.Home.screen)
                },
                icon = { Icon(Icons.Default.Home, "Home") }
            )

            NavigationDrawerItem(
                label = {
                    Text(
                        "Notifications",
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                },
                selected = false,
                onClick = {
                    coroutineScope.launch {
                        sideDrawerState.apply {
                            close()
                        }
                    }
                    navigationController.navigate(Screen.Notifications.screen)
                },
                icon = { Icon(Icons.Default.Notifications, "Notifications") }
            )

            NavigationDrawerItem(
                label = {
                    Text(
                        "Profile",
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                },
                selected = false,
                onClick = {
                    coroutineScope.launch {
                        sideDrawerState.apply {
                            close()
                        }
                    }
                    navigationController.navigate(Screen.Profile.screen)
                },
                icon = { Icon(Icons.Default.Person, "Account") }
            )

            NavigationDrawerItem(
                label = {
                    Text(
                        "Settings",
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                },
                selected = false,
                onClick = {
                    coroutineScope.launch {
                        sideDrawerState.apply {
                            close()
                        }
                    }
                    navigationController.navigate(Screen.Settings.screen)
                },
                icon = { Icon(Icons.Default.Settings, "Settings") }
            )


            NavigationDrawerItem(
                label = {
                    Text(
                        "LogOut",
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                },
                selected = false,
                onClick = {
                    coroutineScope.launch {
                        sideDrawerState.apply {
                            close()
                        }
                    }
                    navigationController.navigate(Screen.Settings.screen)
                },
                icon = { Icon(Icons.AutoMirrored.Filled.ExitToApp, "LogOut") }
            )
        }
    }
}


/*


Create Navigation Side Drawer
    - Needed
        navigation library implementation in gradle

    Steps :
		0. Create Screens
			-  Create a sealed class containing data objects of that sealed class
			{
				sealed class Screen(screen : String){
					data object Home : Screen("home")
					data object Account : Screen("account")
					data object Setting : Screen("setting")
				}
			}
	
        1. initiate with remember
            coroutine scope
            drawer state
            navigation controller
                - normal -
            context ( for toast ) OPTIONAL

        2. Create a modal navigation drawer
        3. Use modal drawer sheet inside drawer content of above
        4. inside them use drawer navigation items
        5. place items and inside it
        6. use logic for onClick
            a. when item is clicked
            b. close the drawer
            c. open the corresponding screen

            - Navigate Using navcontroller.navigate(resId)

            inside main screen page use
                NavHost(){
                    composable(resId){ composableFun() }
                }
				
				
*/