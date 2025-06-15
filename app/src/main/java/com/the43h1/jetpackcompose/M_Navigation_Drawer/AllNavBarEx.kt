package com.the43h1.jetpackcompose.M_Navigation_Drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(
                "Xeron Productions",
                fontWeight = FontWeight.W600,
                fontFamily = FontFamily(Font(R.font.adventure)),
                letterSpacing = 2.5.sp,
                fontSize = 26.sp,
                modifier = Modifier
                    .padding(start = 4.dp, end = 4.dp)
//                textAlign = TextAlign.Center
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    // TODO
                }
            ) {
                Icon(
                    Icons.Default.Menu, "Menu Button", tint = Color.Black,
                    modifier = Modifier
                        .size(35.dp)
                        .padding(start = 8.dp)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.inversePrimary),
//        modifier = Modifier.statusBarsPadding(),
        actions = {

            Icon(
                Icons.Default.Notifications, "Notification",
                tint = Color.Black,
                modifier = Modifier
                    .size(35.dp)
                    .padding(end = 8.dp)
                    .clickable {
                        // TODO
                    }
            )
            Icon(
                Icons.Default.AccountCircle, "Account",
                tint = Color.Black,
                modifier = Modifier
                    .size(35.dp)
                    .padding(end = 8.dp)
                    .clickable {
                        // TODO
                    }
            )

        }
    )
}

@Composable
fun SideNavDrawer(drawerOpened: Boolean, onClick: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxWidth(0.7f)
            .fillMaxHeight()
            .navigationBarsPadding()
//            .padding(start = 16.dp, end = 16.dp, top = 16.dp)

    ) {
        Text(
            "Xeron oG",
            fontWeight = FontWeight.W600,
            fontFamily = FontFamily(Font(R.font.adventure)),
            letterSpacing = 2.5.sp,
            fontSize = 26.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 15.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .clickable {
                    // Todo
                }

        ) {
            Icon(
                Icons.Default.Home, "Home", modifier = Modifier
                    .padding(end = 8.dp)
                    .size(25.dp)
            )
            Text("Home", fontSize = 20.sp)
        }


        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .clickable {
                    // Todo
                }

        ) {
            Icon(
                Icons.Default.Person, "Profile", modifier = Modifier
                    .padding(end = 8.dp)
                    .size(25.dp)
            )
            Text("Profile", fontSize = 20.sp)
        }


        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .clickable {
                    // Todo
                }

        ) {
            Icon(
                Icons.Default.Notifications, "Notification", modifier = Modifier
                    .padding(end = 8.dp)
                    .size(25.dp)
            )
            Text("Notification", fontSize = 20.sp)
        }


        Row(
//            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .weight(0.9f)
                .clickable {
                    // Todo
                }

        ) {
            Icon(
                Icons.Default.Email, "Rate", modifier = Modifier
                    .padding(end = 8.dp)
                    .size(25.dp)
            )
            Text("Contact", fontSize = 20.sp)
        }

        Row(
//            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 20.dp)
                .weight(0.1f, false)
                .clickable {
                    // Todo
                }

        ) {
            Icon(
                Icons.Default.Star, "Rate", modifier = Modifier
                    .padding(end = 8.dp)
                    .size(25.dp)
            )
            Text("Rate Our App", fontSize = 20.sp)
        }


    }
}

@Composable
// Composable for Nav Buttons
fun NavButtons(
    isSelected: Boolean,
    onClick: () -> Unit,
    icon: ImageVector,
    iconDescription: String?,
    modifier: Modifier
) {
    IconButton(
        onClick = {
            onClick()
        },
        content = {
            Icon(
                icon, iconDescription,
                tint = if (isSelected) Color.White else Color.Black,
                modifier = modifier
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar() {
    var allStates: MutableList<Boolean> = remember {
        mutableStateListOf(true, false, false, false, false)
    }

    var sheetState by remember {
        mutableStateOf(false)
    }

    var bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )


    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.inversePrimary
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            NavButtons(
                isSelected = allStates[0],
                onClick = {
                    if (!allStates[0]) {
                        allStates.forEachIndexed { idx, _ ->
                            allStates[idx] = false
                        }
                        allStates[0] = true
                    }
                },
                icon = Icons.Default.Home,
                iconDescription = "Home",
                modifier = Modifier.size(30.dp)
            )


            NavButtons(
                isSelected = allStates[1],
                onClick = {
                    if (!allStates[1]) {
                        allStates.forEachIndexed { idx, _ ->
                            allStates[idx] = false
                        }
                        allStates[1] = true
                    }
                },
                icon = Icons.Default.Search,
                iconDescription = "Search",
                modifier = Modifier.size(30.dp)
            )


            FloatingActionButton(onClick = {
                if (!allStates[2]) {
                    allStates.forEachIndexed { idx, _ ->
                        allStates[idx] = false
                    }
                    allStates[2] = true
                }
            }
            ) {
                if (sheetState) {
                    BottomDrawer(bottomSheetState) {
                        sheetState = false
                    }
                }
                NavButtons(
                    isSelected = allStates[2],
                    onClick = {/*Don't Fill This as its all action are set on the Floating Action Button*/ },
                    icon = Icons.Default.Add,
                    iconDescription = "New Chat",
                    modifier = Modifier.size(30.dp)
                )
            }


            NavButtons(
                isSelected = allStates[3],
                onClick = {
                    if (!allStates[3]) {
                        allStates.forEachIndexed { idx, _ ->
                            allStates[idx] = false
                        }
                        allStates[3] = true
                    }
                },
                icon = Icons.Default.Notifications,
                iconDescription = "Notifications",
                modifier = Modifier.size(30.dp)
            )


            NavButtons(
                isSelected = allStates[4],
                onClick = {
                    if (!allStates[4]) {
                        allStates.forEachIndexed { idx, _ ->
                            allStates[idx] = false
                        }
                        allStates[4] = true
                    }
                },
                icon = Icons.Default.Person,
                iconDescription = "Profile",
                modifier = Modifier.size(30.dp)
            )

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomDrawer(
    bottomSheetState: SheetState,
    onDismissReq: () -> Unit
) {
    // TODO
    ModalBottomSheet(
        onDismissRequest = {
            onDismissReq()
        },
        sheetState = bottomSheetState
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(intrinsicSize = IntrinsicSize.Max)
        ) {
            Text("This is 1st Text")
        }
    }
}

@Composable
fun ScaffoldContent(paddingValues: PaddingValues) {

}

@Composable
fun ModalNavDrawerContent(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() },
        contentColor = MaterialTheme.colorScheme.onPrimary,
        containerColor = MaterialTheme.colorScheme.primary
    ) { padding ->
        ScaffoldContent(padding)
    }
}

@Composable
fun MainApp(modifier: Modifier = Modifier) {
    var drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = MaterialTheme.colorScheme.inversePrimary
            ) {
                SideNavDrawer(
                    drawerState.isOpen,
                    {

                    }
                )

            }
        },
        drawerState = drawerState

    ) {
        ModalNavDrawerContent()
    }
}


@Preview(showSystemUi = true)
@Composable
private fun MainAppPreview() {
    MainApp()
}