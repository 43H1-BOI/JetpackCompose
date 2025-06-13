package com.the43h1.jetpackcompose.L_Scaffold

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ScaffoldLayout() {
    Scaffold(
        topBar = {

        },
        bottomBar = {},
        snackbarHost = {},
        floatingActionButton = {},
        floatingActionButtonPosition = TODO(),
        containerColor = TODO(),
        contentColor = TODO(),
        contentWindowInsets = TODO(),
        modifier = Modifier
    ) { }
}

@Preview(showSystemUi = true)
@Composable
fun ScaffoldPreview() {
    ScaffoldLayout()
}