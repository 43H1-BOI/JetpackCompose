package com.the43h1.jetpackcompose.E_Modal_Sheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PartialBottomSheet() {

    var bottomSheetState by remember {
        mutableStateOf(false)
    }

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        contentAlignment = Alignment.Center
    ) {

        Button(
            onClick = {
                bottomSheetState = true
            }
        ) {
            Text("Bottom Modal Sheet")
        }

        if (bottomSheetState) {
            ModalBottomSheet(
                modifier = Modifier.fillMaxHeight(),
                onDismissRequest = {
                    bottomSheetState = false
                },
                sheetState = sheetState
            ) {
                Text(
                    "This is Content Inside Bottom Sheet , Swipe Down to Dismiss Bottom Sheet",
                    modifier = Modifier,
                    fontSize = 20.sp
                )
            }
        }

    }
}


@Preview(showSystemUi = true)
@Composable
fun PartialModalSheetPreview() {
    PartialBottomSheet()
}