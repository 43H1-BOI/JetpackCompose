package com.the43h1.jetpackcompose.A_Designs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SimpleLoginPageEx(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            "Simple Login Page",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = email,
            onValueChange = {
                email = it
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            label = {
                Text("Email")
            },
            shape = RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            visualTransformation = PasswordVisualTransformation(),
            label = {
                Text("Password")
            },
            shape = RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp)
        )

    }
}

@Composable
fun AnotherLoginPageEx(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            "Accha Login Page",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            label = {
                Text("Email")
            },
            shape = RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp),
            colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.primary)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            label = {
                Text("Password")
            },
            shape = RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp),
            colors = TextFieldDefaults.colors(MaterialTheme.colorScheme.primary)
        )

    }
}

@Preview
@Composable
private fun SimpleLoginPagePreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
//        SimpleLoginPageEx()
        AnotherLoginPageEx()
    }
}