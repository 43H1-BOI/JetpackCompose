package com.the43h1.jetpackcompose.A_Practice_Apps.Unit_Converter_7

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true)
@Composable
fun UnitConv() {
    var userInput by remember {
        mutableStateOf("0".toIntOrNull())
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
    ) {
        Text(
            text = "Unit Converter App",
            fontSize = 26.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))


        OutlinedTextField(
            value = try {
                userInput.toString()
            } catch (e: NumberFormatException) {
                "0"
            } catch (e: Exception) {
                "null + ${e.message}"
            },
            onValueChange = {
                userInput = try {
                    it.toInt()
                } catch (e: NumberFormatException) {
                    0
                }
            }, modifier = Modifier.fillMaxWidth()
        )


        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {

            Box(modifier = Modifier.weight(1f)) {
                Button(
                    onClick = { }, modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxWidth(0.8f)
                ) {
                    Text("Unit")
                    Icon(Icons.Default.ArrowDropDown, "Drop Down")
                }

                DropdownMenu(
                    expanded = false, onDismissRequest = { }, offset = DpOffset(23.dp, 0.dp)
                ) {
                    DropdownMenuItem(text = { Text("Millimeter") }, onClick = {})
                    DropdownMenuItem(text = { Text("Centimeter") }, onClick = {})
                    DropdownMenuItem(text = { Text("Meter") }, onClick = {})
                    DropdownMenuItem(text = { Text("Kilometer") }, onClick = {})
                    DropdownMenuItem(text = { Text("Foot") }, onClick = {})
                    DropdownMenuItem(text = { Text("Inch") }, onClick = {})
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Box(modifier = Modifier.weight(1f)) {
                Button(
                    onClick = { }, modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxWidth(0.8f)
                ) {
                    Text("Unit")
                    Icon(Icons.Default.ArrowDropDown, "Drop Down")
                }

                DropdownMenu(
                    expanded = false, onDismissRequest = { }, offset = DpOffset(23.dp, 0.dp)
                ) {
                    DropdownMenuItem(text = { Text("Millimeter") }, onClick = {})
                    DropdownMenuItem(text = { Text("Centimeter") }, onClick = {})
                    DropdownMenuItem(text = { Text("Meter") }, onClick = {})
                    DropdownMenuItem(text = { Text("Kilometer") }, onClick = {})
                    DropdownMenuItem(text = { Text("Foot") }, onClick = {})
                    DropdownMenuItem(text = { Text("Inch") }, onClick = {})
                }
            }
        }
    }
}