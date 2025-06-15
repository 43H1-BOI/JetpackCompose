package com.the43h1.jetpackcompose.M_Navigation_Drawer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
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
fun SideNavDrawer(modifier: Modifier = Modifier) {

}

@Composable
// Composable for Nav Buttons
fun NavButtons(
    isEnabled: Boolean,
    onClick: () -> Unit,
    icon: ImageVector,
    iconDescription: String?,
    modifier: Modifier,
    otherState: MutableState<Boolean>
) {
    IconButton(
        onClick = {
            onClick()
        },
        content = {
            Icon(
                icon, iconDescription,
                tint = if (isEnabled) Color.White else Color.Black,
                modifier = modifier
            )
        }
    )
}

@Composable
fun BottomBar() {
    var allStates: MutableList<Boolean> = remember {
        mutableStateListOf(true, false, false, false, false)
    }

    BottomAppBar(containerColor = MaterialTheme.colorScheme.inversePrimary) {
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
                }, icon = Icons.Default.Home,
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
                }, icon = Icons.Default.Search,
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
                }, icon = Icons.Default.Notifications,
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
                }, icon = Icons.Default.Person,
                iconDescription = "Profile",
                modifier = Modifier.size(30.dp)
            )

        }
    }
}

@Composable
fun BottomDrawer(modifier: Modifier = Modifier) {

}

@Composable
fun ScaffoldContent(paddingValues: PaddingValues) {

}

@Composable
fun MainApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() },
        contentColor = MaterialTheme.colorScheme.onPrimary,
        containerColor = MaterialTheme.colorScheme.primary
    ) { padding ->
        ScaffoldContent(padding)
    }
}


@Preview(showSystemUi = true)
@Composable
private fun MainAppPreview() {
    MainApp()
}