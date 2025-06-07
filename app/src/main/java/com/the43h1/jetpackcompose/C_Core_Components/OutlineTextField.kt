package com.the43h1.jetpackcompose.C_Core_Components

import android.text.method.PasswordTransformationMethod
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.the43h1.jetpackcompose.R


@Composable
fun OutlinedOne() {
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

@Composable
fun SimpleOne() {
    var rainbow = listOf(
        colorResource(R.color.violet),
        colorResource(R.color.indigo),
        colorResource(R.color.blue),
        colorResource(R.color.green),
        colorResource(R.color.yellow),
        colorResource(R.color.orange),
        colorResource(R.color.red),
    )

    var text by remember {
        mutableStateOf("")
    }

    var rangila = remember {
        Brush.linearGradient(
            colors = rainbow
        )
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        TextField(
            value = text,
            label = {
                Text("Colorful Text")
            },
            onValueChange = {
                text = it
            },
            // brushing over text field
            textStyle = TextStyle(brush = rangila)
        )
    }
}

@Composable
fun PasswordField() {
    var password by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text("Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun OutlineTextFieldPreview() {
//    SimpleOne()
//    OutlinedOne()
    PasswordField()
}