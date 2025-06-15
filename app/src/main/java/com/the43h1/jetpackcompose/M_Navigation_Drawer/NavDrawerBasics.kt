package com.the43h1.jetpackcompose.M_Navigation_Drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.R
import kotlinx.coroutines.future.future

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerBasic(modifier: Modifier = Modifier) {
    var scope = rememberCoroutineScope()

    var drawerState = rememberDrawerState(
        initialValue = DrawerValue.Open
    )

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Column(
                    modifier = Modifier
                        .padding()
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, top = 17.dp, bottom = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Icon(Icons.Default.Face, "App Icon", modifier = Modifier.size(28.dp))
                        Text(
                            "App Icon",
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp,
                            modifier = Modifier
                                .padding(start = 16.dp)
                        )

                    }

                    HorizontalDivider()

                    Text(
                        "Inbox", fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(start = 16.dp, bottom = 8.dp, top = 5.dp)

                    )
                    Text(
                        "Notification",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 8.dp, bottom = 10.dp)
                    )

                    HorizontalDivider()

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp),
//                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.Person, "Profile", modifier = Modifier.size(25.dp))

                        Text(
                            "Profile",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .padding(start = 16.dp, bottom = 8.dp, top = 10.dp)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp),
//                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.Settings, "Settings", modifier = Modifier.size(25.dp))

                        Text(
                            "Settings",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
//                                .align(Alignment.CenterVertically)
                        )
                    }

                    HorizontalDivider()

                    NavigationDrawerItem(
                        label = {
                            Text(
                                "Clickable Text",
                                fontSize = 20.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier
                                    .padding(start = 0.dp, top = 8.dp, bottom = 10.dp)
                            )
                        },
                        selected = false,
                        onClick = {
                            println("Button Clicked")
                        }
                    )

                }
            }
        },
        drawerState = drawerState,
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "App Name", fontSize = 22.sp,
                            modifier = Modifier
                                .padding(start = 10.dp)
                        )
                    },
                    navigationIcon = {
                        Icon(
                            Icons.Default.Menu, "Menu",
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .size(35.dp)
                                .clickable {
                                    scope.future {
                                        drawerState.apply {
                                            if (isClosed) open() else close()
                                        }
                                    }
                                }
                        )
                    },
                    actions = {
                        Icon(
                            Icons.Default.Person, "Menu",
                            modifier = Modifier
                                .padding(end = 16.dp)
                                .size(35.dp)
                        )
                    }
                )
            }
        ) { screenPadding ->
            LazyColumn(
                modifier = Modifier
                    .padding(screenPadding)
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(10) {
                    Column(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .height(200.dp)
                            .background(colorResource(R.color.my_light_primary))
                            .fillMaxWidth()
                    ) {}
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun DrawerBasicsPreview() {
    DrawerBasic()
}