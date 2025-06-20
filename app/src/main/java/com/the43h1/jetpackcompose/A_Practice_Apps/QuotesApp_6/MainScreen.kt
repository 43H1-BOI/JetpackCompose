package com.the43h1.jetpackcompose.A_Practice_Apps.QuotesApp_6

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainQuotesApp(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
//            .background(
//                brush = Brush.linearGradient(
//                    listOf(
//                        colorResource(R.color.violet),
//                        colorResource(R.color.indigo),
//                        colorResource(R.color.blue),
//                        colorResource(R.color.green),
//                        colorResource(R.color.yellow),
//                        colorResource(R.color.red),
////                        colorResource(R.color.violet)
//                    )
//                )
//                brush = Brush.
//            )
    ) {
        LazyColumn(modifier = Modifier.padding()) {

        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PrevQuotes() {
//    CardView(
//        R.drawable.pfp_40_super,
//        "SpiderMan with his GF",
//        "With Great Powers , Comes Great Responsibilities",
//        "Peter Parker"
//    )

//    InnerCard(
//        R.drawable.pfp_40_super,
//        "SpiderMan with his GF",
//        "With Great Powers , Comes Great Responsibilities",
//        "Peter Parker"
//    )

    MainQuotesApp()
}