package com.the43h1.jetpackcompose.A_CheezyCode

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SideEffectsEx() {
    var count by remember {
        mutableStateOf(0)
    }

    Button(
        onClick = {
            count++
        }) {
        Text("Increment Value")
    }
    // Here Log is Running Each Time the Compose Renders
    Log.v("MINE", "Counter = $count")
}

@Composable
fun SideEffectsEx2() {
    var count by remember {
        mutableStateOf(0)
    }

    Button(
        onClick = {
            count++
        }) {
        Text("Increment Value")
    }

    var keyValue = count % 5 == 0
    // Here Log is running only when the value of key changes
    LaunchedEffect(key1 = keyValue) {
        Log.v("2.0", "Counter = $count")
    }
}

@Preview
@Composable
fun SideEffectPrev() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        SideEffectsEx2()
    }
}

/*
Whenever we use composable function they get called many times (as per jetpack compose requirements)
And if we are changing any kind of information inside composable then it may also get affected
which may lead to some side effects
    like
        - if add data to database then will create multiple redundant data
        - if changing any state and that is being used by other fun then function may misfunction

This Problem can be solved with LaunchedEffect(key)
here the statement will only run when state changes
*/