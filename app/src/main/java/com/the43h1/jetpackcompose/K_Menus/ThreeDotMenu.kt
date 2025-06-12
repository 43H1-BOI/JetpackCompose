package com.the43h1.jetpackcompose.K_Menus

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

@Composable
fun ThreeDotMenuEx() {
    var isEnabled by remember {
        mutableStateOf(true)
    }

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.End,
            modifier = Modifier
            .fillMaxWidth()
//                .padding(20.dp)
                .statusBarsPadding()
                .navigationBarsPadding()
        ) {
            Icon(
                Icons.Default.MoreVert, "3 Dot",
                modifier = Modifier
                    .padding(end = 5.dp)
                    .clickable(
                        onClick = {
                            isEnabled = !isEnabled
                        }
                    )
                    .size(30.dp)
            )

            DropdownMenu(
                onDismissRequest = {
                    isEnabled = false
                },
                expanded = isEnabled,
                offset = DpOffset(155.dp,0.dp),
                modifier = Modifier
                .align(Alignment.End)
            ) {
                DropdownMenuItem(
                    text = {
                        Text("Profile")
                    },
                    onClick = {
                        Toast.makeText(context, "Opening Profile", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier
                        .padding(2.dp),
                    leadingIcon = {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = "Profile Section"
                        )
                    }
                )

                DropdownMenuItem(
                    text = {
                        Text("Settings")
                    },
                    onClick = {
                        Toast.makeText(context, "Opening Settings", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier
                        .padding(2.dp),
                    leadingIcon = {
                        Icon(
                            Icons.Default.Settings,
                            contentDescription = "Settings Section"
                        )
                    }
                )

                HorizontalDivider()

                DropdownMenuItem(
                    text = {
                        Text("Send FeedBack")
                    },
                    onClick = {
                        Toast.makeText(context, "Sending FeedBack", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier
                        .padding(2.dp),
                    leadingIcon = {
                        Icon(
                            Icons.Default.Edit,
                            contentDescription = "Feedback Section"
                        )
                    },
                    trailingIcon = {
                        Icon(
                            Icons.AutoMirrored.Filled.Send,
                            contentDescription = "Feedback Section"
                        )
                    }
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ThreeDotMenuPreview() {
    ThreeDotMenuEx()
}