package com.the43h1.jetpackcompose.A_Practice_Apps.Unit_Converter_7

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun UnitConvertorApp() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("Unit Converter")

        var value by remember {
            mutableStateOf("")
        }

        OutlinedTextField(
            value = value,
            onValueChange = {
                value = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Row {
            var isOpened = remember {
                mutableStateListOf(false, false)
            }

            var units = remember {
                getUnits()
            }

            Button(
                onClick = {
                    isOpened[0] = true
                }
            ) {
                if (!isOpened[0]) {
                    Text("Unit")
                }

                if (isOpened[0])
                    DropdownMenu(
                        expanded = isOpened[0],
                        onDismissRequest = {
                            isOpened[0] = false
                        },
                    ) {
                        DropdownMenuItem(
                            text = {
                                LazyColumn(modifier = Modifier.height(70.dp)) {
                                    items(getUnits().count()) { index ->
                                        Text(units[index])
                                    }
                                }
                            },
                            onClick = { }
                        )

                    }
            }

            Button(
                onClick = {
                    isOpened[1] = true
                }
            ) {
                if (isOpened[1])
                    DropdownMenu(
                        expanded = isOpened[1],
                        onDismissRequest = {
                            isOpened[1] = false
                        },
                    ) {
                        LazyColumn(modifier = Modifier.height(70.dp)) {
                            items(getUnits().count()) { index ->
                                Text(units[index])
                            }
                        }
                    }
            }
        }
    }
}

fun getUnits(): MutableList<String> {
    var unitList = mutableListOf<String>()

    unitList.addAll(
        listOf(
            "MILLIMETER",
            "CENTIMETER",
            "METER",
            "KILOMETER",
            "INCH",
            "FOOT"
        )
    )

    return unitList
}