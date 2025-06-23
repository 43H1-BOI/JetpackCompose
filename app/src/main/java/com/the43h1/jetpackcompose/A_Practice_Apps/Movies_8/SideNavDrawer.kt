package com.the43h1.jetpackcompose.A_Practice_Apps.Movies_8

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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

@Preview
@Composable
fun TempPrev() {
    NavDrawerItem(
        iconId = Icons.Default.Person,
        contentDesc = "Person",
        text = "Profile"
    )
}