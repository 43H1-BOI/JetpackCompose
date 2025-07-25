package com.the43h1.jetpackcompose.A_Google

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.R

@Composable
fun MainApp() {
    var isContinued = rememberSaveable {
        mutableStateOf(false)
    }

    Surface(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        if (!isContinued.value)
            GreetingScreen() { isContinued.value = !isContinued.value }
        else
            MainScreen()
    }
}

@Composable
fun GreetingScreen(stateChanged: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            "Welcome to My App",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(10.dp)
        )
        Button(
            onClick = {
                stateChanged()
            }
        ) {
            Text(
                "Continue"
            )
        }
    }
}

@Composable
fun MainScreen() {
    var textItems: List<String> = List(100) { "Text $it" }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        /*
        // Can Do This
        item() {
            for (item in textItems) {
                TextLayout(item)
            }
        }
        */

        //      OR
        items(items = textItems) { item ->
            TextLayout(item)
        }

    }
}

@Composable
fun TextLayout(text: String) {
    var isShowing = rememberSaveable {
        mutableStateOf(false)
    }

    // Hoisting this
    var newPadding = animateDpAsState(
        if (!isShowing.value) 10.dp
        else 45.dp
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(red = 0, green = 104, blue = 143))
            .padding(top = 10.dp, bottom = newPadding.value)
    ) {
        Text(
            text,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .align(Alignment.CenterVertically),
            // Added Material Theme typography
            style = MaterialTheme.typography.bodyMedium
        )
        Button(
            onClick = {
                isShowing.value = !isShowing.value
            }, colors = ButtonDefaults.buttonColors(Color.White)
        ) {
            Text(
                if (!isShowing.value) "Show More" else "Show Less",
                color = colorResource(R.color.my_light_primary),
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    name = "GreetingPreviewDark"
)
@Preview(showSystemUi = true)
@Composable
fun BasicLayoutPreview() {
    MainApp()
}