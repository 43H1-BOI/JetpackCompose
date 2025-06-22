package com.the43h1.jetpackcompose.Z_Extras.TopAppBar

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.the43h1.jetpackcompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun TopAppBarEx(modifier: Modifier = Modifier) {
    val context = LocalContext.current.applicationContext

    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = {
                    Toast.makeText(context, "App Icon", Toast.LENGTH_SHORT).show()
                }
            ) {
                Icon(
                    ImageVector.vectorResource(R.drawable.baseline_backup_24),
                    "App Icon"
                )
            }
        },
        title = {
            Text("My App")
        },
        actions = {
            IconButton(
                onClick = {
                    Toast.makeText(context, "Profile", Toast.LENGTH_SHORT).show()
                }
            ) {
                Icon(Icons.Filled.Person, "Profile")
            }

            IconButton(
                onClick = {
                    Toast.makeText(context, "Search", Toast.LENGTH_SHORT).show()
                }
            ) {
                Icon(Icons.Filled.Search, "Search")
            }

            IconButton(
                onClick = {
                    Toast.makeText(context, "Menu", Toast.LENGTH_SHORT).show()
                }
            ) {
                Icon(Icons.Filled.MoreVert, "Menu")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Blue,
            actionIconContentColor = Color.White,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White
        )
    )
}