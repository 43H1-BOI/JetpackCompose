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
    var userInput by remember { mutableStateOf("0".toInt()) }

    var drawer1 by remember { mutableStateOf(false) }
    var drawer2 by remember { mutableStateOf(false) }

    var inputUnit by remember { mutableStateOf(Units.Centimeter) }
    var outputUnit by remember { mutableStateOf(Units.Meter) }

    var result = 0.0



    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 50.dp)
    ) {
        Text(
            text = "Unit Converter App",
            fontSize = 26.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = try {
                    userInput.toString()
                } catch (_: NumberFormatException) {
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
                }, modifier = Modifier
                    .fillMaxWidth(0.7f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    result = convert(
                        inputUnit = inputUnit,
                        outputUnit = outputUnit,
                        inputValue = userInput
                    )
                },
            ) { Text("Convert") }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {

            Box(modifier = Modifier.weight(1f)) {
                Button(
                    onClick = { drawer1 = true }, modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxWidth(0.8f)
                ) {
                    Text(inputUnit.toString(), fontSize = 14.sp)
                    Icon(Icons.Default.ArrowDropDown, "Drop Down")
                }

                DropdownMenu(
                    expanded = drawer1,
                    onDismissRequest = {
                        drawer1 = false
                    },
                    offset = DpOffset(23.dp, 0.dp)
                ) {
                    DropdownMenuItem(
                        text = { Text(Units.Millimeter.toString()) },
                        onClick = {
                            drawer1 = false
                            outputUnit = Units.Millimeter
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(Units.Centimeter.toString()) },
                        onClick = {
                            drawer1 = false
                            outputUnit = Units.Centimeter
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(Units.Meter.toString()) },
                        onClick = {
                            drawer1 = false
                            outputUnit = Units.Meter
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(Units.Kilometer.toString()) },
                        onClick = {
                            drawer1 = false
                            outputUnit = Units.Kilometer
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Box(modifier = Modifier.weight(1f)) {
                Button(
                    onClick = { drawer2 = true }, modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxWidth(0.8f)
                ) {
                    Text(outputUnit, fontSize = 14.sp)
                    Icon(Icons.Default.ArrowDropDown, "Drop Down")
                }

                DropdownMenu(
                    expanded = drawer2,
                    onDismissRequest = {
                        drawer2 = false
                    },
                    offset = DpOffset(23.dp, 0.dp)
                ) {

                    DropdownMenuItem(
                        text = { Text("Millimeter") },
                        onClick = {
                            drawer2 = false
                            inputUnit = Units.Millimeter
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Centimeter") },
                        onClick = {
                            drawer2 = false
                            inputUnit = "Centimeter"
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Meter") },
                        onClick = {
                            drawer2 = false
                            inputUnit = "Meter"
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Kilometer") },
                        onClick = {
                            drawer2 = false
                            inputUnit = "Kilometer"
                        }
                    )
                }
            }
        }

        if (result != 0.0) {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "Result : $result",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
        }
    }
}


fun convert(inputUnit: Units, outputUnit: Units, inputValue: Int): Double {
    return when (inputUnit) {
        Units.Millimeter ->
            when (outputUnit) {
                Units.Centimeter -> (inputValue / 10).toDouble()
                Units.Meter -> (inputValue / 100).toDouble()
                Units.Kilometer -> (inputValue / 1000).toDouble()
                Units.Millimeter -> inputValue.toDouble()
            }

        Units.Centimeter ->
            when (outputUnit) {
                "Centimeter" -> (inputValue / 10).toDouble()
                "Meter" -> (inputValue / 100).toDouble()
                "Kilometer" -> (inputValue / 1000).toDouble()
            }

        else -> {
            0.0
        }
    }
}


enum class Units() {
    Millimeter,
    Centimeter,
    Meter,
    Kilometer
}