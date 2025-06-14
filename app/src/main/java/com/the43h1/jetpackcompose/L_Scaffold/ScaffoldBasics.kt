package com.the43h1.jetpackcompose.L_Scaffold

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldB() {
    var isFav by remember {
        mutableStateOf(false)
    }

    var modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Top App Bar", modifier = modifier, fontSize = 20.sp)
                },
                navigationIcon = {
                    IconButton(onClick = {

                    }
                    ) {
                        Icon(Icons.Default.Menu, "Menu Button")
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                Text("Bottom App Bar", modifier = modifier, fontSize = 20.sp)
            }

        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    isFav = !isFav
                }
            ) {
                if (isFav)
                    Icon(Icons.Default.Favorite, "Favorite")
                else
                    Icon(Icons.Default.FavoriteBorder, "Not Favorite")
            }
        }
    ) { contentPadding ->
        LazyColumn(
            modifier = Modifier.padding(contentPadding)
        ) {
            items(100) {
                Text(
                    text = ((if(!isFav) "Me Not " else "") + "Love You"),
                    fontSize = 20.sp,
                    modifier = modifier
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ScaffoldPrev() {
    ScaffoldB()
}