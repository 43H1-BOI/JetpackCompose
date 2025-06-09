package com.the43h1.jetpackcompose.C_Core_Components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.R

@Composable
fun IconsEx() {
    var context = LocalContext.current
    var uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Column {
            Text(
                "Clickable Icon",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Icon(
                imageVector = Icons.Default.Edit, // this for Material Icons
                contentDescription = "Edit Button",
                modifier = Modifier
                    .size(200.dp)
                    .align(Alignment.CenterHorizontally)
                    .clickable(
                        onClick = {
                            Toast.makeText(context, "Icon is Clicked", Toast.LENGTH_SHORT).show()
                        }
                    ), tint = Color.Red // this for constant icons

            )

        }

        // painter will work properly only when we add
        // tint = Color.Unspecified
        // because icons are more supposed to be in a constant color

        // we can use IconButton or clickable Modifier to let it act as a button
        Column {
            Text(
                "Clickable Icon Button",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                modifier = Modifier
                    .fillMaxWidth()
            )
            IconButton(
                onClick = {
                    Toast.makeText(context, "Icon Button is Clicked", Toast.LENGTH_SHORT).show()
                    uriHandler.openUri("https://github.com/43H1-BOI")
                }, modifier = Modifier
                    .size(200.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Icon(
                    painter = painterResource(R.drawable.github_icon), // this for custom image
                    contentDescription = null,
                    tint = Color.Unspecified, // this for rangeele icons
                    modifier = Modifier
                        .size(200.dp)
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewIcons() {
    IconsEx()
}