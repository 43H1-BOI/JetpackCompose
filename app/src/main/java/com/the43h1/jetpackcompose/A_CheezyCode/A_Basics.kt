package com.the43h1.jetpackcompose.A_CheezyCode

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.R

@Composable
fun AllBasicsText() {
    var name = "Abhishek Yadav"

    Text(
        "My Name is $name",
        fontWeight = FontWeight.SemiBold,
        color = Color.Red,
        fontFamily = FontFamily(Font(R.font.ap)),
        fontSize = 48.sp,
        letterSpacing = 2.sp,
        textAlign = TextAlign.Center,
        maxLines = 2,
        modifier = Modifier
            .padding(5.dp)
    )
}

@Composable
fun AllBasicsImage() {
    var desc = "Image of Lotus"

    Image(
        painter = painterResource(R.drawable.lotus),
        contentDescription = desc,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .padding(5.dp)
    )
}

@Composable
fun AllBasicsButton() {
    val context = LocalContext.current

    Button(
        onClick = {
            Toast.makeText(context, "Button CLicked !", Toast.LENGTH_SHORT).show()
            // Toast does not work in Preview
        },
        shape = CircleShape,
        modifier = Modifier
            .size(90.dp)
    ) {
        Text("Button")
    }
}

@Composable
fun AllBasicsTextField() {
    var value = remember {
        mutableStateOf("")
    }

    TextField(
        label = { Text("Enter Email") },
        value = value.value,
        leadingIcon = { Icon(Icons.Default.Email, "Email Box") },
        onValueChange = {
            value.value = it
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true
    )

}

@Preview(showSystemUi = true)
@Composable
private fun AllBasicsPreview() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .statusBarsPadding()
    ) {
//        AllBasicsText()
//        AllBasicsImage()
//        AllBasicsButton()
        AllBasicsTextField()
    }
}