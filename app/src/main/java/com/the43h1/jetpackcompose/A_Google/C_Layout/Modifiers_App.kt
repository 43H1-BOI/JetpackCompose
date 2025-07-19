package com.the43h1.jetpackcompose.A_Google.C_Layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.R

@Preview(showBackground = true)
@Composable
fun Modifiers_App(modifier: Modifier = Modifier) {
    var searchValue by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(0xfff4f0ee)
            )
            .padding(16.dp),
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        /** Search Bar */
        TextField(
            leadingIcon = {
                Icon(Icons.Default.Search, "Search")
            },
            label = {
                Row {
                    Text("Search")
                }
            },
            value = searchValue,
            onValueChange = { searchValue = it },
            colors = TextFieldDefaults.colors(unfocusedContainerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        /** Align Your body */
        Text(
            "Align Your Body",
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            AlignCard(R.drawable.ab1_inversions,"Inversions")
            AlignCard(R.drawable.ab2_quick_yoga,"Quick yoga")
            AlignCard(R.drawable.ab3_stretching,"Stretching")
            AlignCard(R.drawable.ab4_tabata,"Tabata")
            AlignCard(R.drawable.ab5_hiit,"Hiit")
            AlignCard(R.drawable.ab6_pre_natal_yoga,"Pre natal yoga")
        }
    }

    BottomAppBar(
        actions = {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(
                    onClick = { TODO() },
                ) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "Home",
                        modifier = Modifier.size(40.dp)
                    )
                }
                Text(
                    text = "Home",
                    textAlign = TextAlign.Center
                )
            }

            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(
                    onClick = { TODO() },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile",
                        modifier = Modifier.size(40.dp)
                    )
                }
                Text(
                    text = "Profile",
                    textAlign = TextAlign.Center
                )
            }
        }
    )

}


@Composable
fun AlignCard(image: Int, description: String) {
    Column {
        Image(
            painter = painterResource(image),
            contentDescription = description,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(110.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = description,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}


@Composable
fun FavCard(image: Int, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .width(280.dp)
            .clip(RoundedCornerShape(12.dp))
            .height(100.dp)
            .background(Color.LightGray.copy(alpha = 0.5f))

    ) {
        Image(
            painter = painterResource(image),
            contentDescription = text,
            contentScale = ContentScale.Crop,
            modifier = Modifier.weight(2f)
        )
        Text(
            text = text,
            modifier = Modifier
                .weight(4f)
                .padding(horizontal = 16.dp),
            textAlign = TextAlign.Left,
            fontSize = 20.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.W300,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}