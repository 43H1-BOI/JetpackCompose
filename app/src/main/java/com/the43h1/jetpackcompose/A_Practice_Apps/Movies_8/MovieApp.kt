package com.the43h1.jetpackcompose.A_Practice_Apps.Movies_8

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.the43h1.jetpackcompose.A_Practice_Apps.Movies_8.Screens.FavoriteScreen
import com.the43h1.jetpackcompose.A_Practice_Apps.Movies_8.Screens.HomeScreen
import com.the43h1.jetpackcompose.A_Practice_Apps.Movies_8.Screens.ProfileScreen
import kotlinx.coroutines.future.future

const val appName = "Movilogy"

@Preview(showSystemUi = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieApp() {
    /** Contains Nav Controller
     * navController is used for Navigating from one screen to other
     */
    var navigationController = rememberNavController()

    /** Stores Coroutine Scope */
    var coroutineScope = rememberCoroutineScope()

    /** Stores Drawer State */
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    /** Contains context of application */
    val context = LocalContext.current.applicationContext


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(
                context,
                coroutineScope,
                drawerState,
                navigationController
            )
        },
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = appName,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    },
                    actions = {
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                Icons.Default.Person,
                                "Profile",
                                modifier = Modifier.size(28.dp)
                            )
                        }

                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                Icons.Default.MoreVert,
                                "More Options",
                                modifier = Modifier.size(28.dp)
                            )
                        }
                    },
                    colors = TopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary,
                        actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
                        scrolledContainerColor = MaterialTheme.colorScheme.primary
                    ),
                    navigationIcon = {
                        Icon(
                            Icons.Default.Menu, "Menu Nav Bar",
                            modifier = Modifier
                                .padding(6.dp)
                                .size(28.dp)
                                .clickable {
                                    coroutineScope.future {
                                        drawerState.apply {
                                            if (isClosed) open() else close()
                                        }
                                    }
                                }
                        )
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        // TODO("will popup add movies bottom drawer")
                        //  Add Movie

                    },
                    containerColor = MaterialTheme.colorScheme.primary
                ) {
                    Icon(Icons.Default.Add, "Add Movie")
                }
            }
        )
        { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(
                        color = MaterialTheme.colorScheme.primaryContainer
                    )
            ) {
                NavHost(
                    navController = navigationController,
                    startDestination = Screen.HomePage.screenName
                ) {
                    composable(Screen.HomePage.screenName) { HomeScreen() }
                    composable(Screen.FavoritePage.screenName) { FavoriteScreen() }
                    composable(Screen.ProfilePage.screenName) { ProfileScreen() }
                }

            }
        }
    }
}