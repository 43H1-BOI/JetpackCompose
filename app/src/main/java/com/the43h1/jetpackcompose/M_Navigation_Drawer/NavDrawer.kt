package com.the43h1.jetpackcompose.M_Navigation_Drawer

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.R
import kotlinx.coroutines.launch


@Composable
// Screen Content Composable
fun ScreenContent(
    paddingValue: PaddingValues, // Scaffold Padding Values
    color: Color = colorResource(R.color.skyBlue), // Color for Box
    text: String? = null // Text Inside Box
) {
    Box(
        modifier = Modifier
            .padding(paddingValue)
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(8) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .clip(RoundedCornerShape(25.dp))
                        .background(color = color)
                        .fillMaxWidth()
                        .height(200.dp)
                ) {
                    Text(
                        text ?: "None",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )
                }
            }
        }

    }
}

@Composable
// Drawer Content Composable
private fun DrawerContent(modifier: Modifier = Modifier) {
    Column() {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(R.drawable.github_icon), null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(60.dp)
                    .padding(start = 15.dp, top = 10.dp, bottom = 3.dp)
            )

            Text(
                text = "App Name",
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 18.dp, start = 22.dp, end = 10.dp)
            )
        }

        HorizontalDivider(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp))


        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                Icons.Default.Person, "Profile",
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 25.dp, top = 10.dp, bottom = 3.dp)
            )

            Text(
                text = "Profile",
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                    .align(Alignment.CenterVertically)
            )
        }


        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                Icons.Default.Notifications, "Notifications",
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 25.dp, top = 10.dp, bottom = 3.dp)
            )

            Text(
                text = "Notifications",
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                    .align(Alignment.CenterVertically)
            )
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        ) {
            Icon(
                Icons.Default.Email, "Inbox",
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 25.dp, top = 10.dp, bottom = 3.dp)
            )

            Text(
                text = "Inbox",
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                    .align(Alignment.CenterVertically)
            )
        }


        HorizontalDivider(
            modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp)
                .align(Alignment.End)
        )



        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                Icons.Default.Settings, "Ssttings",
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 25.dp, top = 10.dp, bottom = 3.dp)
            )

            Text(
                text = "Settings",
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                    .align(Alignment.CenterVertically)
            )
        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
// Top App Bar Content Composable
private fun TopBar(onOpenDrawer: () -> Unit, modifier: Modifier = Modifier) {
    TopAppBar(
        navigationIcon = {
            Icon(
                Icons.Default.Menu, "Menu",
                Modifier
                    .size(35.dp)
                    .padding(start = 8.dp)
                    .clickable {
                        onOpenDrawer()
                    }
            )
        },
        title = {
            Text(
                text = "App Name",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
            )
        }, actions = {
            Icon(
                Icons.Default.Notifications,
                "Notification",
                modifier = Modifier
                    .padding(start = 10.dp, end = 5.dp)
                    .size(26.dp)
            )
            Icon(
                Icons.Default.Person,
                "Person",
                modifier = Modifier
                    .padding(start = 5.dp, end = 10.dp)
                    .size(26.dp)
            )
        }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
        ), modifier = Modifier
            .statusBarsPadding()
            .padding(
                start = 8.dp, end = 8.dp, bottom = 10.dp
            )
            .clip(RoundedCornerShape(30.dp))

    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
// Final Screen Composable
private fun MainScreen() {
    var drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    var scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                DrawerContent()
            }
        },
        drawerState = drawerState,
    ) {
        Scaffold(
            topBar = {
                TopBar(
                    onOpenDrawer = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                            //      OR
//                            if (drawerState.isClosed)
//                                drawerState.open()
//                            else
//                                drawerState.close()
                        }
                    }
                )
            }
        ) { paddingValue ->
            ScreenContent(paddingValue)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun NavDrawerPrev() {
    MainScreen()
}