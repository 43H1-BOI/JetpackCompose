package com.the43h1.jetpackcompose.A_Google.C_Layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var button1 by mutableStateOf(true)

        setContent {
            JetpackComposeTheme {
                val windowSize = calculateWindowSizeClass(this)

                Row {
                    when (windowSize.widthSizeClass) {
                        WindowWidthSizeClass.Expanded -> {
                            LayoutAppVertical(
                                button1 = button1,
                                onClick1 = { if (!button1) button1 = true },
                                onClick2 = { if (button1) button1 = false })
                        }

                        WindowWidthSizeClass.Compact -> {
                            LayoutAppHorizontal(
                                button1 = button1,
                                onClick1 = { if (!button1) button1 = true },
                                onClick2 = { if (button1) button1 = false })
                        }
                    }
                }
            }
        }
    }
}

@Preview("Horizontal")
@Composable
fun LayoutAppHorizontal(
    button1: Boolean = true,
    onClick1: () -> Unit = {},
    onClick2: () -> Unit = {}
) {
    Scaffold(
        bottomBar = {
            BottomNavBarHorizontal(
                button1 = button1,
                onClick1 = { onClick1() },
                onClick2 = { onClick2() })
        }
    ) { paddingValues ->
        Modifiers_App(paddingValues)
    }
}

@Preview("Vertical", device = "spec:width=2340px,height=1080px,dpi=440")
@Composable
fun LayoutAppVertical(
    button1: Boolean = true,
    onClick1: () -> Unit = {},
    onClick2: () -> Unit = {}
) {
    Scaffold(
        bottomBar = {
            BottomNavBarVertical(
                button1 = button1,
                onClick1 = { onClick1() },
                onClick2 = { onClick2() })
        }
    ) { paddingValues ->
        Modifiers_App(paddingValues)
    }
}


@Composable
fun Modifiers_App(paddingValues: PaddingValues = PaddingValues(10.dp)) {
    var searchValue by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .background(Color(0xfff4f0ee))
            .padding(horizontal = 16.dp)
            .fillMaxSize(),
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        /** Search Bar */

        TextField(
            leadingIcon = {
                Icon(Icons.Default.Search, "Search")
            },
            label = {
                Text("Search")
            },
            value = searchValue,
            onValueChange = {
                searchValue = it
            },
            colors = TextFieldDefaults.colors(unfocusedContainerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        /** Align Your body */
        Text(
            "Align Your Body",
            fontWeight = FontWeight.W400,
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
        ) {
            items(AlignList) { item ->
                AlignCard(item.image, item.title)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        /** Favorite Collections Section */
        Text(
            "Favorite Collections",
            fontWeight = FontWeight.W400,
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            modifier = Modifier.height(200.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(FavList) { item ->
                FavCard(item.image, item.title)
            }
        }
    }
}