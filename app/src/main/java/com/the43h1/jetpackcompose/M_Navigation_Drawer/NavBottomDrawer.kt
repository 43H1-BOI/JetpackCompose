package com.the43h1.jetpackcompose.M_Navigation_Drawer

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavBottomDrawer() {
//    var sheetState = rememberModalBottomSheetState()

    var drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    var scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {

        }, drawerState = drawerState
    ) {}

    ModalBottomSheet(
        onDismissRequest = {}
    ) { }

}

@Preview(showSystemUi = true)
@Composable
fun NavBottomDrawerPreview() {
    NavBottomDrawer()
}