package com.the43h1.jetpackcompose.G_CheckBox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CheckBoxEx() {
    val context = LocalContext.current

    var listItems: List<String> = listOf("Option 1", "Option 2", "Option 3")


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = "Select Items",
            textAlign = TextAlign.Left,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )

        listItems.forEach { eachItems ->
            var checkedItem by remember {
                mutableStateOf(false)
            }

            Row {
                Checkbox(
                    checked = checkedItem,
                    onCheckedChange =
                        { checkedStatus ->
                            checkedItem = checkedStatus
                        },
                    modifier = Modifier
                        .size(27.dp)
                )

                Text(
                    text = eachItems,
                    textAlign = TextAlign.Left,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }


        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewCheckBox() {
    CheckBoxEx()
}