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

    // All Important Variables
    // For UserInput Values
    var userInput by remember { mutableStateOf("0".toInt()) }

    // For DropDown States
    var drawer1 by remember { mutableStateOf(false) }
    var drawer2 by remember { mutableStateOf(false) }

    // For Units Stored in Variables
    var inputUnit by remember { mutableStateOf(Units.Centimeter) }
    var outputUnit by remember { mutableStateOf(Units.Meter) }

    // For Result
    var result by remember {
        mutableStateOf(0.0)
    }

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
                    userInput = it.toInt()
                }, modifier = Modifier
                    .fillMaxWidth(0.7f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    result = try {
                        convert(
                            inputUnit = inputUnit,
                            outputUnit = outputUnit,
                            inputValue = userInput
                        )
                    } catch (_: NumberFormatException) {
                        0.0
                    }
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
                UnitSelectionButton(
                    drawerState = drawer1,
                    onClickButton = { drawer1 = true },
                    onDismissDD = { drawer1 = false },
                    currentUnit = inputUnit,
                    selectedUnit = { inputUnit = it },
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Box(modifier = Modifier.weight(1f)) {
                UnitSelectionButton(
                    drawerState = drawer2,
                    onClickButton = { drawer2 = true },
                    onDismissDD = { drawer2 = false },
                    currentUnit = outputUnit,
                    selectedUnit = { outputUnit = it },
                )
            }
        }

        if (isConverted) {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "Result : $result",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
private fun UnitSelectionButton(
    drawerState: Boolean, // Drawer State
    onClickButton: () -> Unit, // What Happen when button is clicked
    onDismissDD: () -> Unit, // What Happen when Dropdown is dismissed
    currentUnit: Units, // For Button Value
    selectedUnit: (Units) -> Unit // On Unit Change
) {
    Button(
        onClick = { onClickButton() },
        modifier = Modifier
//            .align(Alignment.Center)
            .fillMaxWidth(0.8f)
    ) {
        Text(currentUnit.toString(), fontSize = 14.sp)
        Icon(Icons.Default.ArrowDropDown, "Drop Down")
    }

    DropdownMenu(
        expanded = drawerState,
        onDismissRequest = {
            onDismissDD()
        },
        offset = DpOffset(23.dp, 0.dp)
    ) {
        DropdownMenuItem(
            text = { Text(Units.Millimeter.toString()) },
            onClick = {
                onDismissDD()
                selectedUnit(Units.Millimeter)
            }
        )
        DropdownMenuItem(
            text = { Text(Units.Centimeter.toString()) },
            onClick = {
                onDismissDD()
                selectedUnit(Units.Centimeter)
            }
        )
        DropdownMenuItem(
            text = { Text(Units.Meter.toString()) },
            onClick = {
                onDismissDD()
                selectedUnit(Units.Meter)
            }
        )
        DropdownMenuItem(
            text = { Text(Units.Kilometer.toString()) },
            onClick = {
                onDismissDD()
                selectedUnit(Units.Kilometer)
            }
        )
    }
}

fun convert(inputUnit: Units, outputUnit: Units, inputValue: Int): Double {
    return when (inputUnit) {
        Units.Millimeter ->
            when (outputUnit) {
                Units.Millimeter -> inputValue
                Units.Centimeter -> (inputValue.toDouble() / 10)
                Units.Meter -> (inputValue.toDouble() / 1000)
                Units.Kilometer -> (inputValue.toDouble() / 1000000)
            }.toDouble()

        Units.Centimeter ->
            when (outputUnit) {
                Units.Millimeter -> (inputValue * 10)
                Units.Centimeter -> inputValue
                Units.Meter -> (inputValue.toDouble() / 100)
                Units.Kilometer -> (inputValue.toDouble() / 100000)
            }.toDouble()

        Units.Meter ->
            when (outputUnit) {
                Units.Millimeter -> (inputValue * 1000)
                Units.Centimeter -> (inputValue * 100)
                Units.Meter -> inputValue
                Units.Kilometer -> (inputValue.toDouble() / 1000)
            }.toDouble()

        Units.Kilometer ->
            when (outputUnit) {
                Units.Millimeter -> (inputValue * 1000000)
                Units.Centimeter -> (inputValue * 100000)
                Units.Meter -> (inputValue * 1000)
                Units.Kilometer -> inputValue
            }.toDouble()
    }
}

enum class Units() {
    Millimeter,
    Centimeter,
    Meter,
    Kilometer
}