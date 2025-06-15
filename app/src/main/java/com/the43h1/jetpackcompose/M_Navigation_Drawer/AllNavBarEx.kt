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
fun BottomBar(
    iconsList: Map<ImageVector, String?> = mapOf(
        Icons.Default.Home to "Home",
        Icons.Default.Search to "Search",
        Icons.Default.Add to "New Chat",
        Icons.Default.Notifications to "Notifications",
        Icons.Default.Person to "Profile",
    )
) {

    var otherState = remember { mutableStateOf(false) }

    BottomAppBar(containerColor = MaterialTheme.colorScheme.inversePrimary) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            iconsList.forEach { item ->
                var isEnabled = remember {
                    mutableStateOf(false)
                }

                NavButtons(
                    isEnabled = isEnabled.value,
                    otherState = otherState,
                    onClick = {
                        if (!otherState.value) {
                            isEnabled.value = !isEnabled.value
                            otherState.value = !otherState.value
                        } else{

                        }
                    }, icon = item.key,
                    iconDescription = item.value,
                    modifier = Modifier.size(30.dp)
                )
            }
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