package com.the43h1.jetpackcompose.A_Practice_Apps

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.R
import com.the43h1.jetpackcompose.ui.theme.JetpackComposeTheme
import kotlinx.coroutines.future.future

@Composable
// Screen Content Composable
private fun ScreenContent(
    paddingValue: PaddingValues, // Scaffold Padding Values
    colorBox: Color = MaterialTheme.colorScheme.primary, // Color for Box
    colorText: Color = MaterialTheme.colorScheme.onPrimary,
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
                        .background(color = colorBox)
                        .fillMaxWidth()
                        .height(200.dp)
                ) {
                    Text(
                        text ?: "None",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorText
                    )
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(
    titleClick: () -> Unit = {},    // For Click on Title
    navFun: () -> Unit,         // For Nav Button's OnClick
    action1: () -> Unit = {},   // For Click on Action 1 Icon
    action2: () -> Unit = {}, // For Click on Action 2 Icon
    isDark: Boolean, // For Ui State
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
                        titleClick()
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
                imageVector =
                    ImageVector.vectorResource(
                        if (isDark)
                            R.drawable.light_mode
                        else
                            R.drawable.dark_mode
                    ),
                contentDescription = "UI Modes",
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
            color = MaterialTheme.colorScheme.onPrimary,
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
                    .size(25.dp),
                tint = MaterialTheme.colorScheme.onBackground
            )
            Text(
                "Home", fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
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
                    .size(25.dp),
                tint = MaterialTheme.colorScheme.onBackground
            )
            Text(
                "Profile", fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
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
                    .size(25.dp),
                tint = MaterialTheme.colorScheme.onBackground

            )
            Text(
                "Notification", fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
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
                    .size(25.dp),
                tint = MaterialTheme.colorScheme.onBackground

            )
            Text(
                "Contact Us", fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
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
                    .size(25.dp),
                tint = MaterialTheme.colorScheme.onBackground
            )
            Text(
                "Rate Our App", fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
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
                tint = if (isSelected)
                    MaterialTheme.colorScheme.onSecondary
                else
                    MaterialTheme.colorScheme.onBackground,
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
) {

    var allStates: MutableList<Boolean> = remember {
        mutableStateListOf(true, false, false, false)
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
// TODO
private fun BottomDrawer(
    onDismissReq: () -> Unit
) {
    var sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    ModalBottomSheet(
        onDismissRequest = {
            onDismissReq()
        },
        sheetState = sheetState,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column {
            Text("This is 1st Text")
        }
    }
}

@Composable
private fun ScaffoldContent(
    paddingValues: PaddingValues,
    text: String? = null
) {
    // Temporary Content
    ScreenContent(
        paddingValues,
        MaterialTheme.colorScheme.onSecondary,
        MaterialTheme.colorScheme.secondary,
        text
    )
}

@Composable
fun MainApp() {
    // Side Drawer State
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    // For Bottom Drawer
    var isSheetOpen by remember { mutableStateOf(false) }

    var scope = rememberCoroutineScope()

    // Dark Mode Switching
    var isDark by remember { mutableStateOf(false) }

    JetpackComposeTheme(isDark) {
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
                    TopBar(
                        navFun = {
                            scope.future {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }

                        },
                        action1 = {
                            isDark = !isDark
                        },
                        isDark = isDark
                    )
                },
                bottomBar = {
                    BottomBar(
                        clickOption3 = {
                            isSheetOpen = true
                        }
                    )
                },
                contentColor = MaterialTheme.colorScheme.onPrimary,
                containerColor = MaterialTheme.colorScheme.primary
            ) { padding ->
                ScaffoldContent(padding, "Home")
            }

            if (isSheetOpen) {
                BottomDrawer { isSheetOpen = false }
            }
        }
    }
}


@Suppress("VisualLintAccessibilityTestFramework")
@Preview(showSystemUi = true)
@Composable
private fun MainAppPreview() {
    MainApp()
}

/* Documentation :-

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




# MainApp()
    has initial value for side nav drawer
    also for bottom drawer
*/

// Problems Occurring
//  1. A Bottom Drawer Open at App Startup
//  2. Then Nothing is Working