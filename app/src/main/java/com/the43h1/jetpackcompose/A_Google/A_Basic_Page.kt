package com.the43h1.composeArticle.Practice

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.R
import com.the43h1.jetpackcompose.ui.theme.JetpackComposeTheme

/*
inside Main Function
 Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MainPage(
                        // Alternate Way of Getting String Resource
                        stringResource(R.string.name_),
                        stringResource(R.string.para1),
                        stringResource(R.string.para2),
                        modifier = Modifier.padding(16.dp)
                    )
                }
*/


@Composable
fun MainPage(
    name: String,
    message1: String,
    message2: String,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Image(
            painter = painterResource(R.drawable.bg_compose_background),
            contentDescription = null,
            contentScale = ContentScale.Fit,
        )
        Text(
            text = name,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)


        )
        Text(
            text = message1,
            modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp),
            textAlign = TextAlign.Justify


        )
        Text(
            text = message2,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTheme {
//        val head1: String = "Jetpack Compose tutorial"
//        val para1: String =
//            "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs."
//        val para2: String =
//            "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name."
//        MainPage(
//            head1,
//            para1,
//            para2,
//            modifier = Modifier
//        )

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainPage(
                // Alternate Way of Getting String Resource
                stringResource(R.string.name_),
                stringResource(R.string.para1),
                stringResource(R.string.para2),
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}