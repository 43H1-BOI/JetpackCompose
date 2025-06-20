package com.the43h1.jetpackcompose.A_Practice_Apps.QuotesApp_6

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the43h1.jetpackcompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainQuotesApp(modifier: Modifier = Modifier) {

    val quotesList = mutableListOf<QuotesDetails>(
        QuotesDetails("With Great Powers , Comes Great Responsibilities", "Peter Parker"),
        QuotesDetails("With Great Aalo , Comes Great Samosa", "Mukesh Pawar"),
        QuotesDetails("With Great Dal , Comes Great Kachori", "Ramesh Singh"),
        QuotesDetails("With Great Processor , Comes Great Laptop", "Tushar Kharade"),
        QuotesDetails("With Great Nani , Comes Great Maal Pani", "Abhishek Yadav"),
        QuotesDetails("With Great Khana , Comes Great Dakaar", "Also Abhishek Yadav"),
        QuotesDetails("With Great Pen , Comes Great Handwriting", "Spider Man"),
        QuotesDetails("With Great Script , Comes Great Responsibility", "Spider Man"),
        QuotesDetails("With Great Bag , Comes Great Storage Space", "Spider Man"),
    )

    var state by remember {
        mutableStateOf(false)
    }

    var idx by remember {
        mutableIntStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        Text(
            text = stringResource(R.string.quotesApp),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp)
//                .height(50.dp)
                .align(Alignment.CenterHorizontally)
        )
        if (state) {
            InnerCard(
                R.drawable.monkey,
                "Spoider Mon",
                quotesList[idx].quote,
                quotesList[idx].author,
                onClick = {
                    state = false
                }
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
        ) {
            items(quotesList.count()) { index ->
                quotesList[index].apply {
                    CardView(
                        R.drawable.pfp_51_super,
                        "Spoider Mon",
                        quote,
                        author,
                        modifier = Modifier.clickable {
                            state = true
                            idx = index
                        }
                    )
                }
            }
        }
    }
}

data class QuotesDetails(
    val quote: String,
    val author: String
)

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