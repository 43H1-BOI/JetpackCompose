package com.the43h1.jetpackcompose.A_Practice_Apps.Movies_8

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun NavDrawerItem(
    iconId: ImageVector?,
    contentDesc: String?,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        if (iconId != null) {
            Icon(
                imageVector = iconId,
                contentDescription = contentDesc,
                tint = MaterialTheme.colorScheme.onPrimary,
            )
        }
        Text(
            text = text,
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
internal fun DrawerContent(
    context: Context?,
    coroutineScope: CoroutineScope,
    drawerState: DrawerState,
    navigationController: NavHostController
) {
    ModalDrawerSheet(
        modifier = Modifier
            .fillMaxWidth(0.7f),
        drawerContainerColor = MaterialTheme.colorScheme.primary,
        drawerContentColor = MaterialTheme.colorScheme.onSecondary,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .clickable {
                    Toast.makeText(context, "Movilogy App", Toast.LENGTH_SHORT).show()
                },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.MailOutline, "Movilogy App Logo")
            Spacer(Modifier.width(8.dp))
            Text(
                "Movilogy",
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp,
            )
        }

        Spacer(Modifier.height(16.dp))

        NavigationDrawerItem(
            label = {
                NavDrawerItem(
                    Icons.Default.Home,
                    "Home Button",
                    "Home"
                )
            },
            selected = false,
            onClick = {
                coroutineScope.launch {
                    drawerState.close()
                }
                navigationController.navigate(Screen.HomePage.screenName)
            }
        )

        NavigationDrawerItem(
            label = {
                NavDrawerItem(
                    Icons.Default.Favorite,
                    "Favorite Button",
                    "Favorite"
                )
            },
            selected = false,
            onClick = {
                coroutineScope.launch {
                    drawerState.close()
                }
                navigationController.navigate(Screen.FavoritePage.screenName)
            }
        )

        NavigationDrawerItem(
            label = {
                NavDrawerItem(
                    Icons.AutoMirrored.Filled.Send,
                    "Watchlist Button",
                    "Watchlist"
                )
            },
            selected = false,
            onClick = {
                coroutineScope.launch {
                    drawerState.close()
                }
                navigationController.navigate(Screen.HomePage.screenName)
//                        TODO("Add Watchlist Page)
            }
        )

        NavigationDrawerItem(
            label = {
                NavDrawerItem(
                    Icons.Filled.Person,
                    "Profile Button",
                    "Profile"
                )
            },
            selected = false,
            onClick = {
                coroutineScope.launch {
                    drawerState.close()
                }
                navigationController.navigate(Screen.ProfilePage.screenName)
            }
        )

        NavigationDrawerItem(
            label = {
                NavDrawerItem(
                    Icons.AutoMirrored.Filled.ExitToApp,
                    "Logout Button",
                    "Logout"
                )
            },
            selected = false,
            onClick = {
                coroutineScope.launch {
                    drawerState.close()
                }
                Toast.makeText(context, "Logging Out", Toast.LENGTH_SHORT).show()
//                        TODO("Add Login Page Here + Logout Animation")
//                        navigationController.navigate(Screen.HomePage.screenName)
            }
        )
    }
}

@Preview
@Composable
fun TempPrev() {
    NavDrawerItem(
        iconId = Icons.Default.Person,
        contentDesc = "Person",
        text = "Profile"
    )
}