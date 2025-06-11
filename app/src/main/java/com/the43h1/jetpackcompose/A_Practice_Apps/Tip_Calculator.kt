package com.the43h1.jetpackcompose.A_Practice_Apps

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.R
import kotlin.math.roundToInt

// To Calculate Tip Logic for Tip Layout 2
var calcTipLogic: (Int, Int) -> Float = { costOfService, tipPercent ->
    (costOfService * (tipPercent.toFloat() / 100))
}

@Composable
fun LayoutTip1() {
    var context = LocalContext.current

    var billAmount by remember {
        mutableIntStateOf(0)
    }

    var tip by remember {
        mutableFloatStateOf(0.0f)
    }

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxWidth()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.tipCalc),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )


        TextField(
            value = billAmount.toString(),
            onValueChange = {
                try {
                    billAmount = it.toInt()
                } catch (e: NumberFormatException) {
                    Toast.makeText(context, "Please Enter Valid Number", Toast.LENGTH_SHORT).show()
                }
            },
            label = {
                Text("Enter Bill Amount")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier
                .padding(top = 30.dp)
//                .border(
//                    width = 2.dp,
//                    brush = Brush.linearGradient(
//                        colors = listOf(
//                            Color.Red,
//                            Color.Green,
//                            Color.Blue
//                        )
//                    ), shape = RectangleShape
//                )
        )

        Text(
            text =
                if (billAmount != 0) {
                    tip = (billAmount * 0.05).toFloat()
                    "Thanks for \u20B9${tip} Tip \nMay You Got All Happiness in Your Life"
                } else "Please Enter Bill Amount :)",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 20.dp)
        )
    }
}

@Composable
fun LayoutTip2() {

    var costOfService: Int by remember {
        mutableIntStateOf(0)
    }

    var tipPercent: Int by remember {
        mutableIntStateOf(0)
    }

    var toogleSwitch: Boolean by remember {
        mutableStateOf(false)
    }

    var tip: Float by remember {
        mutableFloatStateOf(0.0f)
    }

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxWidth()
//            .background(Color.LightGray)
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.tipCalc),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )

        TextField(
            value = costOfService.toString(),
            onValueChange = {
                costOfService = it.toInt()
            },
            label = {
                Text("Cost of Service")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            ),
            modifier = Modifier
                .padding(top = 30.dp)
        )

        TextField(
            value = tipPercent.toString(),
            onValueChange = {
                tipPercent = it.toInt()
            },
            label = {
                Text("Tip(%)")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            ),
            modifier = Modifier
                .padding(top = 15.dp)
        )
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                "Round Off Tip?",
                textAlign = TextAlign.Start,
                modifier = Modifier
//                    .align(Alignment.CenterVertically)
//                    .padding(start = 10.dp)
            )
            Switch(
                checked = toogleSwitch,
                onCheckedChange = {
                    toogleSwitch = !toogleSwitch
                    tip.roundToInt()
                }, thumbContent = {
                    AnimatedVisibility(toogleSwitch) {
                        Icon(Icons.Default.Done, null)
                    }

//                    ?else
//                    Icon(Icons.Default.Close, null)
                }, modifier = Modifier
//                    .height(10.dp)
//                    .size(200.dp)
            )
        }

        Text(
            text =
                if (costOfService == 0) "Enter Cost of Service"
                else if (tipPercent == 0) "Enter Tip Percentage"
                else {
                    tip = calcTipLogic(
                        costOfService,
                        tipPercent
                    )
                    "Thanks for \u20B9${
                        if (!toogleSwitch) tip
                        else tip.roundToInt()
                    } Tip \nMay You Got All Happiness in Your Life"
                },
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 20.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewFun() {
    LayoutTip1()
//    LayoutTip2()
}