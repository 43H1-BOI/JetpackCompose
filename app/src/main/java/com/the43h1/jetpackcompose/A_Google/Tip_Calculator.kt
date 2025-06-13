package com.the43h1.composeArticle.Practice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.R

@Composable
fun LayoutTip1() {
    var tip by remember {
        mutableFloatStateOf(0.0f)
    }

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxWidth()
            .padding(10.dp),
//            .background(Color.LightGray),
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
//                .align(Alignment.Start)
        )

        TextField(
            value = tip.toString(),
            onValueChange = {
                tip = it.toFloat()
            },
            label = {
                Text("Enter Your Tip")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal
            ),
            modifier = Modifier
                .padding(top = 30.dp)
        )

        Text(
            text =
                if (tip != 0.0f) {
                    "Thanks for \u20B9$tip Tip \nMay You Got All Happiness in Your Life"
                } else "Please Enter a Tip Amount :)",
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

    var costOfService by remember {
        mutableIntStateOf(0)
    }

    var tipPercent by remember {
        mutableIntStateOf(0)
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

        Text(
            text =
                if (costOfService == 0) "Enter Cost of Service"
                else if (tipPercent == 0) "Enter Tip Percentage"
                else {
                    "Thanks for \u20B9${
                        calcTipLogic(
                            costOfService,
                            tipPercent
                        )
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


// To Calculate Tip Logic for Tip Layout 2
fun calcTipLogic(costOfService: Int, tipPercent: Int) =
    (costOfService * (tipPercent.toFloat() / 100))


@Preview(showSystemUi = true)
@Composable
fun PreviewFun() {
    LayoutTip2()
}