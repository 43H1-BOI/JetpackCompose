package com.the43h1.jetpackcompose.S_Badges

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.the43h1.jetpackcompose.ui.theme.Red
import com.the43h1.jetpackcompose.ui.theme.White

@Composable
fun BadgesEx(modifier: Modifier = Modifier) {
    var count by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BadgedBox(
            badge = {
                if (count > 0) {
                    Badge(
                        containerColor = Red,
                        contentColor = White,
                        content = {
                            Text("$count")
                        }
                    )
                }
            }
        ) {
            Icon(Icons.Default.Notifications, "Notifications")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                count++
            }
        ) {
            Text("Add Notification")
        }
    }
}

@Preview
@Composable
private fun BadgesPreview() {
    Surface {
        BadgesEx()
    }
}


/** How to Badge
 *      Create a count variable for badge with mutable state with value 0
 *      Create a BadgedBox()
 *          - define badge as if(count > 0){
 *              Only then Badge will show up
 *              Create Badge() with
 *                  - contentColor
 *                  - containerColor
 *                  - content of badge
 *          }
 *
 *     Implement your logic to increment count (I've used Button)
 *     All Set
 */