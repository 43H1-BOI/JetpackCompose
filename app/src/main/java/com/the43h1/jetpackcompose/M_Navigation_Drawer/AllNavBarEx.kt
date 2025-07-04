package com.the43h1.jetpackcompose.M_Navigation_Drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.future.future

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(
    titleClick: () -> Unit = {},    // For Click on Title
    navFun: () -> Unit,         // For Nav Button's OnClick
    action1: () -> Unit = {},   // For Click on Action 1 Icon
    action2: () -> Unit = {}    // For Click on Action 2 Icon
) {
    TopAppBar(
        // Title of Top App Bar
        title = {
            Text(
                "Xeron Productions",
                fontWeight = FontWeight.W600,
                fontFamily = FontFamily(Font(R.font.adventure)),
                letterSpacing = 2.5.sp,
                fontSize = 26.sp,
                modifier = Modifier
                    .padding(start = 4.dp, end = 4.dp)
                    .clickable {
                        titleClick
                    }
            )
        },

        // Navigation Icon (Menu)
        navigationIcon = {
            IconButton(
                onClick = {
                    navFun()
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

        // Color of Top App Nav Bar
        colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.inversePrimary),

        // More Buttons on Right Side Of Screen
        actions = {
            Icon(
                Icons.Default.Notifications, "Notification",
                tint = Color.Black,
                modifier = Modifier
                    .size(35.dp)
                    .padding(end = 8.dp)
                    .clickable {
                        action1()
                    }
            )
            Icon(
                Icons.Default.AccountCircle, "Account",
                tint = Color.Black,
                modifier = Modifier
                    .size(35.dp)
                    .padding(end = 8.dp)
                    .clickable {
                        action2()
                    }
            )

        }
    )
}

@Composable
private fun SideNavDrawer(
    titleClick: () -> Unit = {},    // For Click on Title
    option1Click: () -> Unit = {},  // For Click on Option 1
    option2Click: () -> Unit = {},  // For Click on Option 2
    option3Click: () -> Unit = {},  // For Click on Option 3
    option4Click: () -> Unit = {},  // For Click on Option 4
    option5Click: () -> Unit = {}   // For Click on Option 5
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxWidth(0.7f)
            .fillMaxHeight()
            .navigationBarsPadding()
            .background(MaterialTheme.colorScheme.inversePrimary)
    ) {
        // Title For Nav Drawer
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
                .clickable {
                    titleClick()
                }
        )

        // Option 1 : Home
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .clickable {
                    option1Click()
                }
        ) {
            Icon(
                Icons.Default.Home, "Home", modifier = Modifier
                    .padding(end = 8.dp)
                    .size(25.dp)
            )
            Text("Home", fontSize = 20.sp)
        }


        // Option 2 : Profile
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .clickable {
                    option2Click()
                }
        ) {
            Icon(
                Icons.Default.Person, "Profile", modifier = Modifier
                    .padding(end = 8.dp)
                    .size(25.dp)
            )
            Text("Profile", fontSize = 20.sp)
        }


        // Option 3 : Notification
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .clickable {
                    option3Click()
                }
        ) {
            Icon(
                Icons.Default.Notifications, "Notification", modifier = Modifier
                    .padding(end = 8.dp)
                    .size(25.dp)
            )
            Text("Notification", fontSize = 20.sp)
        }


        // Option 4 : Contact Us
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .weight(0.9f)
                .clickable {
                    option4Click()
                }
        ) {
            Icon(
                Icons.Default.Email, "Contact Us", modifier = Modifier
                    .padding(end = 8.dp)
                    .size(25.dp)
            )
            Text("Contact Us", fontSize = 20.sp)
        }


        // Option 5 : Rate Our App
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 20.dp)
                .weight(0.1f, false)
                .clickable {
                    option5Click()
                }
        ) {
            Icon(
                Icons.Default.Star, "Rate Our App", modifier = Modifier
                    .padding(end = 8.dp)
                    .size(25.dp)
            )
            Text("Rate Our App", fontSize = 20.sp)
        }
    }
}

@Composable
// Composable for Nav Buttons
private fun NavButtons(
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
private fun BottomBar(
    clickOption1: () -> Unit = {},  // For Click on Option 1
    clickOption2: () -> Unit = {},  // For Click on Option 2
    clickOption3: () -> Unit = {},  // For Click on Option 3
    clickOption4: () -> Unit = {},  // For Click on Option 4
    clickOption5: () -> Unit = {},   // For Click on Option 5
    allStates: MutableList<Boolean> = remember {
        mutableStateListOf(true, false, false, false)
    }
) {

    var sheetState by remember {
        mutableStateOf(false)
    }

    var bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)

    if (sheetState) {
        BottomDrawer(bottomSheetState) {
            sheetState = false
        }
    }

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
                    clickOption1()

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
                    clickOption2()
                },
                icon = Icons.Default.Search,
                iconDescription = "Search",
                modifier = Modifier.size(30.dp)
            )


            FloatingActionButton(
                onClick = {
                    sheetState = true
                    clickOption3()
                },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    Icons.Default.Add, "More Options",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }

            NavButtons(
                isSelected = allStates[2],
                onClick = {
                    if (!allStates[2]) {
                        allStates.forEachIndexed { idx, _ ->
                            allStates[idx] = false
                        }
                        allStates[2] = true
                    }
                    clickOption4()
                },
                icon = Icons.Default.Notifications,
                iconDescription = "Notifications",
                modifier = Modifier.size(30.dp)
            )


            NavButtons(
                isSelected = allStates[3],
                onClick = {
                    if (!allStates[3]) {
                        allStates.forEachIndexed { idx, _ ->
                            allStates[idx] = false
                        }
                        allStates[3] = true
                    }
                    clickOption5()
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
private fun BottomDrawer(
    bottomSheetState: SheetState,
    onDismissReq: () -> Unit
) {
    // TODO
    ModalBottomSheet(
        onDismissRequest = {
            onDismissReq()
        },
        sheetState = bottomSheetState,
        scrimColor = MaterialTheme.colorScheme.inversePrimary,
        modifier = Modifier
            .fillMaxWidth()
//            .height(intrinsicSize = IntrinsicSize.Min)
    ) {
        Text("This is 1st Text")
    }
}

@Composable
private fun ScaffoldContent(
    paddingValues: PaddingValues,
    text: String?
) {
    // Temporary Content
    ScreenContent(paddingValues, MaterialTheme.colorScheme.onSecondary, text)
}

@Composable
private fun MainApp() {
    var drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    var scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            SideNavDrawer()
        },
        drawerState = drawerState,
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        Scaffold(
            topBar = {
                TopBar(navFun = {
                    scope.future {
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }

                })
            },
            bottomBar = { BottomBar() },
            contentColor = MaterialTheme.colorScheme.onPrimary,
            containerColor = MaterialTheme.colorScheme.primary
        ) { padding ->
            ScaffoldContent(padding, null)
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun MainAppPreview() {
    MainApp()
}


/** Documentation :-

# All Functions Summary :
1. TopBar() -> For All TopBar Contents
2. SideNavDrawer() -> For Side Navigation Drawer Content
3. NavButtons() -> For Navigation Buttons
4. BottomBar() -> For Bottom Navigation Bar
5. BottomDrawer() -> For Bottom Navigation Drawer which pops out when we press + icon
6. ScaffoldContent() -> Contents of App
7. MainApp() -> All App Components Combined


# Approach :
1. TopBar() ->

 */