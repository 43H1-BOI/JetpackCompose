package com.the43h1.jetpackcompose.A_Google.C_Layout

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AlignCard(
    @DrawableRes image: Int,
    description: String
) {
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
fun FavCard(
    @DrawableRes image: Int,
    text: String
) {
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
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.W300,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}

@Composable
fun BottomNavBarHorizontal(
    button1: Boolean = true,
    button2: Boolean = !button1,
    onClick1: () -> Unit = {},
    onClick2: () -> Unit = {},
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    NavigationBar(containerColor = Color(0xffe6e1de)) {
        Row(
            modifier = modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavigationBarItem(
                selected = button1,
                onClick = { onClick1() },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home",
                        modifier = Modifier.size(35.dp)
                    )
                },
                label = {
                    Text(
                        text = "Home",
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                },
                colors = NavigationBarItemDefaults.colors(indicatorColor = Color(0xffe8e1dc))
            )

            NavigationBarItem(
                selected = button2,
                onClick = { onClick2() },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile",
                        modifier = Modifier.size(35.dp)
                    )
                },
                label = {
                    Text(
                        text = "Profile",
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                    )
                },
                colors = NavigationBarItemDefaults.colors(indicatorColor = Color(0xffe8e1dc))
            )
        }
    }
}


@Composable
fun BottomNavBarVertical(
    button1: Boolean = true,
    button2: Boolean = !button1,
    onClick1: () -> Unit = {},
    onClick2: () -> Unit = {},
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    NavigationRail(containerColor = Color(0xffe6e1de)) {
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationRailItem(
                selected = button1,
                onClick = { onClick1() },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home",
                        modifier = Modifier.size(35.dp)
                    )
                },
                label = {
                    Text(
                        text = "Home",
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                },
                colors = NavigationRailItemDefaults.colors(indicatorColor = Color(0xffe8e1dc))
            )

            NavigationRailItem(
                selected = button2,
                onClick = { onClick2() },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile",
                        modifier = Modifier.size(35.dp)
                    )
                },
                label = {
                    Text(
                        text = "Profile",
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                    )
                },
                colors = NavigationRailItemDefaults.colors(indicatorColor = Color(0xffe8e1dc))
            )
        }
    }
}