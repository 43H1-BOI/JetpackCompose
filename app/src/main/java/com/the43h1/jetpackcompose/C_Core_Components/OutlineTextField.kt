package com.the43h1.jetpackcompose.C_Core_Components

import android.widget.Space
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun SimpleOne() {
    // remember is used to let ui remember the start state so that it can proceed to next state
    // to save state locally
    var email by remember {
        // it will remember this state
        // i.e. blank string is at start
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("***")
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        OutlinedTextField(
            // this is initial value inside text field
            value = email,
            // when the text changes , values inside text field also changes
            onValueChange = {
                email = it
            },
            // this is label text which is shown in text field
            label = {
                Text(
                    text = "Email"
                )
            }
        )

//        Spacer(Modifier.width(20.dp))
        /*
//  I Don't Know how to do this ( add two text fields )
        OutlinedTextField(
        value = password,
        onValueChange = {
        password = it
        },
        label = {
        Text(
        text = "Password"
        )
        }
        )
        */
    }

    /*
    this is used to save the last state means
    when there is change in state then the ui forgets its state
    so to remember the state , we use this(rememberSaveable)
    To save state w.r.t. UI

    var texT by rememberSaveable {
        mutableStateOf("")
    }
    */
}


@Preview(showSystemUi = true)
@Composable
fun OutlineTextFieldPreview() {
    SimpleOne()
}