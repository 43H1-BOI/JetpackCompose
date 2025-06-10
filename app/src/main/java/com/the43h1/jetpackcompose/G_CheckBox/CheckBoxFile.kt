package com.the43h1.jetpackcompose.G_CheckBox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CheckBoxEx() {
    val context = LocalContext.current

    // Having multiple checkbox default values
    val childCheckList = remember {
        mutableListOf(false, false, false)
    }

    // A Parent which get selected when all are selected,
    // unselected when none are selected And
    // shows partial selection when some of members are selected

    var parentCheckList = {
        when {
            childCheckList.all { it } -> ToggleableState.On
            childCheckList.none() -> ToggleableState.Off
            childCheckList.any() -> ToggleableState.Indeterminate
            //          OR
            // else -> ToggleableState.Indeterminate
        }
    }




    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .padding(top = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
//            Checkbox(
//                checked = false,
//                modifier = Modifier.background(Color.Cyan),
//                enabled = false,
//                colors = CheckboxDefaults.colors(Color.Black),
//                onCheckedChange = TODO(),
//                interactionSource = TODO()
//            )
            TriStateCheckbox(
                state = ToggleableState.Off,
                onClick = {
                    val newState = parentCheckList != ToggleableState.On

                    childCheckList.forEachIndexed { index, _ ->
                        childCheckList[index] = newState
                    }
//                    Toast.makeText(context, "All Selected", Toast.LENGTH_SHORT).show()
                },
                modifier = TODO(),
                enabled = TODO(),
                colors = TODO(),
                interactionSource = TODO(),
            )

            Text(
                "Select All",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Left
            )
        }
        Row(
            modifier = Modifier
                .padding(top = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
//            Checkbox(
//                checked = false,
//                modifier = Modifier.background(Color.Cyan),
//                enabled = false,
//                colors = CheckboxDefaults.colors(Color.Black),
//                onCheckedChange = TODO(),
//                interactionSource = TODO()
//            )

            Text(
                "Option 1",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Left
            )
        }
        Row(
            modifier = Modifier
                .padding(top = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
//            Checkbox(
//                checked = false,
//                modifier = Modifier.background(Color.Cyan),
//                enabled = false,
//                colors = CheckboxDefaults.colors(Color.Black),
//                onCheckedChange = TODO(),
//                interactionSource = TODO()
//            )

            Text(
                "Option 2",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Left
            )
        }
        Row(
            modifier = Modifier
                .padding(top = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
//            Checkbox(
//                checked = false,
//                modifier = Modifier.background(Color.Cyan),
//                enabled = false,
//                colors = CheckboxDefaults.colors(Color.Black),
//                onCheckedChange = TODO(),
//                interactionSource = TODO()
//            )

            Text(
                "Option 3",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Left
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewCheckBox() {
    CheckBoxEx()
}