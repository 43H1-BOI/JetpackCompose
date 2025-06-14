package com.the43h1.jetpackcompose.L_Scaffold

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldLayout() {
    var context = LocalContext.current.applicationContext

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
//                            .background(MaterialTheme.colorScheme.primary)
                    ) {
                        Text("Contacts")
                    }
                },
                navigationIcon = {
                    Icon(Icons.Default.Menu, null, Modifier.clickable {

                    }
                    )
                },
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Icon(
                        Icons.Default.AccountBox, null,
                        modifier = Modifier
                            .size(50.dp)
                            .clickable {
                                Toast.makeText(context, "1st Button Clicked", Toast.LENGTH_SHORT)
                                    .show()
                            }
                    )
                    Icon(
                        Icons.Default.AccountCircle, null,
                        modifier = Modifier
                            .size(50.dp)
                            .clickable {
                                Toast.makeText(context, "2nd Button Clicked", Toast.LENGTH_SHORT)
                                    .show()
                            }
                    )
                    Icon(
                        Icons.Default.Face, null,
                        modifier = Modifier
                            .size(50.dp)
                            .clickable {
                                Toast.makeText(context, "3rd Button Clicked", Toast.LENGTH_SHORT)
                                    .show()
                            }
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                Toast.makeText(context, "Build Button Clicked", Toast.LENGTH_SHORT).show()
            }
            ) {
                Icon(Icons.Default.Build, null)
            }
        },
        contentColor = MaterialTheme.colorScheme.onPrimary,
        modifier = Modifier
            .navigationBarsPadding()
            .statusBarsPadding()
    ) { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    "Contacts 1",
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    modifier = Modifier
                        .fillMaxWidth()
                )

                Text(
                    "9630456018",
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ScaffoldPreview() {
    ScaffoldLayout()
}